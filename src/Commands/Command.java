
public interface Command {

    boolean canHandle();

    Command execute(Game target);

    void SetTarget(Game target);

    void undo();
}
