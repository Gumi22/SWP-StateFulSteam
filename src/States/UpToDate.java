

public class UpToDate extends InstalledState {

    @Override
    public void start(Game g, Installed i) {
        System.out.println("Starting Game...Welcome to " + g.getName());
        //i.setState(new Outdated()); -> Only i
        g.setState(new Playing());
    }

    @Override
    public void update(Game g, Installed i) {
        System.out.println("Game is already up to date :D");
    }

    @Override
    public boolean canStart() {
        return true;
    }
}
