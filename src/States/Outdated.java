
public class Outdated extends InstalledState{


    @Override
    public void update(Game g, Installed i) {
        System.out.println("Updating Game...please wait...");
        i.setState(new UpToDate());
    }

    @Override
    public boolean canUpdate() {
        return true;
    }
}
