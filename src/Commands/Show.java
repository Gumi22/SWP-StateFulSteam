public class Show implements Command {
    @Override
    public Command execute(Game target) {
        System.out.println("Name: " + target.getName());
        System.out.println("Price: " + target.getPrice());
        System.out.println("State: " + target.getState());
        return new Show();
    }

    @Override
    public void setTarget(Game target) {
    }

    @Override
    public void undo() {
    }
}
