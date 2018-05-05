public class Start implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.start();
        Command cm = new Start();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.quit();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canStart();
    }
}