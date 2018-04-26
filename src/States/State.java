
public abstract class State {

    public void buy(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void download(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void install(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void start(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void pause(Game g){ System.out.println("Not Possible, Game is currently " + g.getState() + "!"); }

    public void resume(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void quit(Game g){ System.out.println("Not Possible, Game is currently " + g.getState() + "!"); }

    public void deinstall(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void delete(Game g){ System.out.println("Not Possible, Game is currently " + g.getState() + "!"); }

    public void sell(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void lend(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }

    public void takeBack(Game g) { System.out.println("Not Possible, Game is currently " + g.getState() + "!"); }

    public void update(Game g){
        System.out.println("Not Possible, Game is currently " + g.getState() + "!");
    }
}
