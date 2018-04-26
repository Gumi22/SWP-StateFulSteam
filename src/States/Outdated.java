
public class Outdated extends InstalledState{

    @Override
    public void start(Game g, Installed i) {
        update(g, i);
        i.start(g);
    }

    @Override
    public void update(Game g, Installed i) {
        System.out.println("Updating Game...please wait...");
        i.setState(new UpToDate());
    }
}
