public class BuyForAFriend extends Makro {

    @Override
    public Command execute(Game target) {

        executeCommand(new Buy(), target);
        executeCommand(new Lend(), target);

        return copyOfThisMakro(this);
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canBuy();
    }

}
