public class Install implements Command {

    private Game target;

    @Override
    public Command execute(Game target) {
        target.install();
        Command cm = new Install();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        this.target = target;
    }

    @Override
    public void undo() {
        target.deinstall();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canInstall();
    }
}
