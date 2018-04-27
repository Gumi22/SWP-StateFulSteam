public class BuyForAFriend implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.buy();
        target.lend();
        Command cm = new BuyForAFriend();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target)  {
        t = target;
    }

    @Override
    public void undo() {
        t.takeBack();
        t.sell();
    }
}
