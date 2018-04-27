public class Download implements Command {

    private Game target;

    @Override
    public Command execute(Game target) {
        target.download();
        Command cm = new Download();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        this.target = target;
    }

    @Override
    public void undo() {
        target.delete();
    }
}
