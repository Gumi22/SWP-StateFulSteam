
import java.util.Random;

public class Installed extends State {
    protected InstalledState state = null;
    private static final Random rnd = new Random(12354);

    public Installed(){
        if(rnd.nextBoolean()){
            state = new Outdated();
        }
        else{
            state = new UpToDate();
        }
    }

    protected void setState(InstalledState i){
        state = i;
    }

    @Override
    public void start(Game g){
        this.state.start(g, this);
    }

    @Override
    public void update(Game g) {
        this.state.update(g, this);
    }

    @Override
    public void deinstall(Game g) {
        System.out.println("Deinstalling ... please wait ... deinstalled :D");
        g.setState(new Downloaded());
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
    public boolean canStart() {
        return this.state.canStart();
    }

    @Override
    public boolean canUpdate() {
        return this.state.canUpdate();
    }

    @Override
    public boolean canDeinstall() {
        return true;
    }
}
