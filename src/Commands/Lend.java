public class Lend implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.lend();
        Command cm = new Lend();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.takeBack();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canLend();
    }
}
