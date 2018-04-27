public class TakeBack implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.takeBack();
        Command cm = new TakeBack();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.lend();
    }
}