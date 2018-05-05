
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

    public boolean canBuy(){
        return false;
    }
    public boolean canDownload(){
        return false;
    }
    public boolean canInstall(){
        return false;
    }
    public boolean canStart(){
        return false;
    }
    public boolean canPause(){ return false; }
    public boolean canResume(){
        return false;
    }
    public boolean canQuit(){
        return false;
    }
    public boolean canDeinstall(){
        return false;
    }
    public boolean canDelete(){
        return false;
    }
    public boolean canSell(){
        return false;
    }
    public boolean canLend(){
        return false;
    }
    public boolean canTakeBack(){ return false; }
    public boolean canUpdate(){
        return false;
    }


}
