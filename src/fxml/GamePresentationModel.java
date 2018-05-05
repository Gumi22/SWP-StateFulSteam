import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GamePresentationModel {

    private Game g;
    private StringProperty name;
    private StringProperty price;
    private StringProperty status;

    public GamePresentationModel(Game g){
        this.g = g;
        this.name = new SimpleStringProperty(g.getName());
        this.price = new SimpleStringProperty(g.getPrice());
        this.status = new SimpleStringProperty(g.getState());
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public Game getG() {
        return g;
    }
}
