import java.util.Stack;

public class Makro implements Command{

    protected Stack<Command> executed = new Stack<>();

    protected void executeCommand(Command cm, Game target){
        executed.add(cm.execute(target));
    }

    @Override
    public void undo() {
        undoAllCommands();
    }

    protected void undoAllCommands(){
        for ( int i = executed.size(); i > 0; i-- ) {
            executed.pop().undo();
        }
    }

    @Override
    public Command execute(Game target) {
        return new Makro();
    }

    @Override
    public void setTarget(Game target)  {
        //useless in this case ;)
    }

    protected Command copyOfThisMakro(Makro cm){
        Makro newM = new Makro();

        newM.executed = cm.executed;
        cm.executed = new Stack<Command>();

        return newM;
    }

}
