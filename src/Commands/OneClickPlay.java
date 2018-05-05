import java.util.Stack;

public class OneClickPlay extends Makro {


    @Override
    public Command execute(Game target) {

        executeCommand(new Buy(), target);
        executeCommand(new Download(), target);
        executeCommand(new Install(), target);
        executeCommand(new Update(), target);
        executeCommand(new Start(), target);

        return copyOfThisMakro(this);
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canBuy();
    }

}
