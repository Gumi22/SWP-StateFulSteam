public class Sell  implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.sell();
        Command cm = new Sell();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.buy();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canSell();
    }
}