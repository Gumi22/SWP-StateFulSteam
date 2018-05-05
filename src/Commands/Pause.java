public class Pause implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.pause();
        Command cm = new Pause();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.resume();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canPause();
    }
}
