public class Quit implements Command{

    private Game t;

    @Override
    public Command execute(Game target) {
        target.quit();
        Command cm = new Quit();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target) {
        t = target;
    }

    @Override
    public void undo() {
        t.start();
    }
}
