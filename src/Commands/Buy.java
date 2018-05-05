public class Buy implements Command{

    Game target;

    @Override
    public boolean canExecute(Game target) {
        return target.canBuy();
    }

    @Override
    public Command execute(Game target) {
        target.buy();
        Command executed = new Buy();
        executed.setTarget(target);
        return executed;
    }

    @Override
    public void setTarget(Game target) {
        this.target = target;
    }

    @Override
    public void undo() {
        target.sell();
    }
}
