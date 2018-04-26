public class Buy implements Command{
    @Override
    public boolean canHandle() {
        return false;
    }

    @Override
    public Command execute(Game target) {
        return null;
    }

    @Override
    public void SetTarget(Game target) {

    }

    @Override
    public void undo() {

    }
}
