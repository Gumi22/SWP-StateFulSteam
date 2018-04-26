
public class InStore extends State {

    @Override
    public void buy(Game g) {
        System.out.println("Congratulations you now bought " + g.getName() + " for only " + g.getPrice() + "€!");
        g.setState(new Bought());
    }

    @Override
    public void download(Game g) {
        buy(g);
        g.download();
    }

    @Override
    public void install(Game g) {
        buy(g);
        g.install();
    }

    @Override
    public void start(Game g) {
        buy(g);
        g.start();
    }
}
