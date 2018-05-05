import javax.swing.*;

public class Show implements Command {
    @Override
    public Command execute(Game target) {
        System.out.println("Name: " + target.getName());
        System.out.println("Price: " + target.getPrice());
        System.out.println("State: " + target.getState());
        JOptionPane.showMessageDialog(null, "Preis: " + target.getPrice() + "\nSatstus: " + target.getState(),  "Über Name: " + target.getName(), JOptionPane.INFORMATION_MESSAGE);
        return new Show();
    }

    @Override
    public void setTarget(Game target) {
    }

    @Override
    public void undo() {
    }

    @Override
    public boolean canExecute(Game target) {
        return true;
    }
}
