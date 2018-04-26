
public class Playing extends State {

    @Override
    public void quit(Game g) {
        System.out.println("Quitting Game...");
        g.setState(new Installed());
    }

    @Override
    public void pause(Game g) {
        System.out.println("Pausing Game...");
        g.setState(new Paused());
    }
}
