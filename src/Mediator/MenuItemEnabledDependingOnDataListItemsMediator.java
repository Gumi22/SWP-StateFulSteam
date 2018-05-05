import javafx.collections.ObservableList;

import java.util.Objects;
import java.util.Stack;

public class MenuItemEnabledDependingOnDataListItemsMediator {
    MainController myMC;

    public MenuItemEnabledDependingOnDataListItemsMediator(MainController mc){
        myMC = mc;
    }

    public void Update(ObservableList<Game> dataList){

        for (Game g: dataList ) {
            if(Objects.equals(g.getName(), "Damn")){
                myMC.newGameMenuItem.setDisable(true);
            }
        }

    }

    public void Update(Stack<Command> myHistory){

        if(myHistory.empty()){
            myMC.UndoMenuItem.setDisable(true);
        }else {
            myMC.UndoMenuItem.setDisable(false);
        }

    }
}
