public class OneClickPlay implements Command {

    private Game t;

    @Override
    public Command execute(Game target) {
        target.buy();
        target.download();
        target.install();
        target.update();
        target.start();
        Command cm = new OneClickPlay();
        cm.setTarget(target);
        return cm;
    }

    @Override
    public void setTarget(Game target)  {
        t = target;
    }

    @Override
    public void undo() {
        t.quit();
        t.deinstall();
        t.delete();
        t.sell();
    }
}
