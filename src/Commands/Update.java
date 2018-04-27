public class Update implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.update();
        Command cm = new Update();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        System.out.println("Not possible, who would do that?");
    }
}