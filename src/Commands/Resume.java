public class Resume implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.resume();
        Command cm = new Resume();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.pause();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canResume();
    }
}