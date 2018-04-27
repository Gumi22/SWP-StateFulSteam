
public interface Command {

    Command execute(Game target);

    void setTarget(Game target);

    void undo();
}
