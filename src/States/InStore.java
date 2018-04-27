
public class InStore extends State {

    @Override
    public void buy(Game g) {
        System.out.println("Congratulations you now bought " + g.getName() + " for only " + g.getPrice() + "€!");
        g.setState(new Bought());
    }

}
