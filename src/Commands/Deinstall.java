public class Deinstall implements Command{

    Game target;

    @Override
    public Command execute(Game target) {
        target.deinstall();
        Command cm = new Deinstall();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        this.target = target;
    }

    @Override
    public void undo() {
        target.install();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canDeinstall();
    }
}
