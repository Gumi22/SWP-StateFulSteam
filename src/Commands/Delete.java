public class Delete implements Command {

    Game g;

    @Override
    public Command execute(Game target) {
        target.delete();
        Command cm = new Delete();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        g = target;
    }

    @Override
    public void undo() {
        g.download();
    }

    @Override
    public boolean canExecute(Game target) {
        return target.canDelete();
    }
}
