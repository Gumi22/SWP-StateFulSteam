
public class Downloaded extends State {

    @Override
    public void delete(Game g) {
        System.out.println("Successfully deleted your game");
        g.setState(new Bought());
    }

    @Override
    public void install(Game g) {
        System.out.println("Successfully installed your game");
        g.setState(new Installed());
    }

    @Override
    public void lend(Game g) {
        System.out.println("You've lent you Game to Kevin, make sure you get it back!");
        g.setState(new Lent(this));
    }

    @Override
    public boolean canLend() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canInstall() {
        return true;
    }
}
