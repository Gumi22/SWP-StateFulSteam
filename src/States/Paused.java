
public class Paused extends State {

    @Override
    public void resume(Game g) {
        System.out.println("Resuming Game...");
        g.setState(new Playing());
    }

    @Override
    public void quit(Game g) {
        System.out.println("Quitting Game...");
        g.setState(new Installed());
    }

    @Override
    public boolean canResume() {
        return true;
    }

    @Override
    public boolean canQuit() {
        return true;
    }
}
