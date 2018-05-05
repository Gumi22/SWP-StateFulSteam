import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class MainController implements Initializable {

    @FXML
    public TableView<Game> GameList;
    public Button buyBtn;
    public Button buyForAFriendBtn;
    public Button deinstallBtn;
    public Button deleteBtn;
    public Button downloadBtn;
    public Button installBtn;
    public Button lendBtn;
    public Button oneClickPlayBtn;
    public Button pauseBtn;
    public Button quitBtn;
    public Button resumeBtn;
    public Button sellBtn;
    public Button showBtn;
    public Button startBtn;
    public Button takeBackBtn;
    public Button updateBtn;
    public MenuItem newGameMenuItem;
    public MenuItem UndoMenuItem;

    private ButtonEnabledDependingOnSelectedGameMediator visibilityMediator;
    private MenuItemEnabledDependingOnDataListItemsMediator enabledMediator;

    private ObservableList<Game> dataList;

    private Stack<Command> myHistory = new Stack<>();

    private Game selectedGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        visibilityMediator = new ButtonEnabledDependingOnSelectedGameMediator(this);
        enabledMediator = new MenuItemEnabledDependingOnDataListItemsMediator(this);

        dataList = FXCollections.observableArrayList(
                        new Game("Minecraft", "20 €"),
                        new Game("Fortnite", "0 €"),
                        new Game("Cuphead", "15 €"),
                        new Game("GTA 5", "60 €"));

        TableColumn columnName = new TableColumn("Name");
        columnName.setCellValueFactory(new PropertyValueFactory<Game,String>("name"));
        columnName.setMinWidth(60);

        TableColumn columnPrice = new TableColumn("Preis");
        columnPrice.setCellValueFactory(new PropertyValueFactory<Game,String>("price"));
        columnPrice.setMinWidth(60);

        TableColumn columnState = new TableColumn("Status");
        columnState.setCellValueFactory(new PropertyValueFactory<Game,String>("state"));


        columnState.setMinWidth(60);


        //GameList.itemsProperty().bind(new SimpleListProperty<>(dataList));
        GameList.getColumns().addAll(columnName, columnPrice, columnState);
        GameList.setItems(dataList);

        GameList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedGame = newSelection;
                visibilityMediator.Update(selectedGame);
            }
        });

        GameList.getSelectionModel().selectFirst();

        dataList.addListener((ListChangeListener<Game>) c -> {
            enabledMediator.Update(dataList);
        });

        UndoMenuItem.setDisable(true);

    }

    public void onBtnAbout(ActionEvent actionEvent) {
         JOptionPane.showMessageDialog(null, "Hingepfuscht von Thiago Gumhold \n 2018",  "Über  StatefulSteam", JOptionPane.INFORMATION_MESSAGE);
    }

    public void onBtnExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void undoCommand(){
        try{
            myHistory.pop().undo();
            GameList.refresh();
            visibilityMediator.Update(selectedGame);
            enabledMediator.Update(myHistory);
        }catch (Exception e){
            System.out.println("Not Possible");
        }
    }

    public void buy(ActionEvent actionEvent) {
        addCommand(new Buy().execute(selectedGame));
    }

    public void buyForAFriend(ActionEvent actionEvent) {
        addCommand(new BuyForAFriend().execute(selectedGame));
    }

    public void deinstall(ActionEvent actionEvent) {
        addCommand(new Deinstall().execute(selectedGame));
    }

    public void delete(ActionEvent actionEvent) {
        addCommand(new Delete().execute(selectedGame));
    }

    public void download(ActionEvent actionEvent) {
        addCommand(new Download().execute(selectedGame));
    }

    public void install(ActionEvent actionEvent) {
        addCommand(new Install().execute(selectedGame));
    }

    public void lend(ActionEvent actionEvent) {
        addCommand(new Lend().execute(selectedGame));
    }

    public void OneClickPlay(ActionEvent actionEvent) {
        addCommand(new OneClickPlay().execute(selectedGame));
    }

    public void pause(ActionEvent actionEvent) {
        addCommand(new Pause().execute(selectedGame));
    }

    public void quit(ActionEvent actionEvent) {
        addCommand(new Quit().execute(selectedGame));
    }

    public void resume(ActionEvent actionEvent) {
        addCommand(new Resume().execute(selectedGame));
    }

    public void sell(ActionEvent actionEvent) {
        addCommand(new Sell().execute(selectedGame));
    }

    public void show(ActionEvent actionEvent) {
        addCommand(new Show().execute(selectedGame));
    }

    public void start(ActionEvent actionEvent) {
        addCommand(new Start().execute(selectedGame));
    }

    public void takeBack(ActionEvent actionEvent) {
        addCommand(new TakeBack().execute(selectedGame));
    }

    public void update(ActionEvent actionEvent) {
        addCommand(new Update().execute(selectedGame));
    }

    private void addCommand(Command c){
        myHistory.push(c);
        visibilityMediator.Update(selectedGame);
        enabledMediator.Update(myHistory);
        GameList.refresh();
    }

    public void onBtnNewGame(ActionEvent actionEvent) {
        dataList.add(new Game("Damn", "XXX €"));
        GameList.refresh();
    }

    public void onBtnUndo(ActionEvent actionEvent) {
        undoCommand();
    }
}
