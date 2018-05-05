
public interface Command {

    boolean canExecute(Game target);

    Command execute(Game target);

    void setTarget(Game target);

    void undo();
}
