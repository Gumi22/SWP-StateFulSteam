
public class Lent extends State{

    State previousState = new Bought();

    public Lent(State prev){
        previousState = prev;
    }

    @Override
    public void takeBack(Game g) {
        System.out.println("You took your Game back from Kevin, congrats");
        g.setState(previousState);
    }
}
