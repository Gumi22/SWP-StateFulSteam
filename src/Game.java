
public class Game {
    private State s = new InStore();
    private String name;
    private String price;
    
    public Game(String name, String price){
        this.name = name;
        this.price = price;
    }

    public void setState(State s){
        this.s = s;
    }

    public void buy(){ s.buy(this); }

    public void download(){
        s.download(this);
    }

    public void install(){
        s.install(this);
    }

    public void start(){
        s.start(this);
    }

    public void pause(){
        s.pause(this);  
    }

    public void resume(){
        s.resume(this);
    }

    public void quit(){
        s.quit(this);
    }

    public void deinstall(){
        s.deinstall(this);
    }

    public void delete(){
        s.delete(this);
    }

    public void sell(){
        s.sell(this);
    }

    public void lend(){
        s.lend(this);
    }

    public void takeBack() {
        s.takeBack(this);
    }

    public void update(){
        s.update(this);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getState(){
        return s.toString();
    }

    public boolean canBuy(){
        return s.canBuy();
    }
    public boolean canDownload(){
        return s.canDownload();
    }
    public boolean canInstall(){
        return s.canInstall();
    }
    public boolean canStart(){
        return s.canStart();
    }
    public boolean canPause(){ return s.canPause(); }
    public boolean canResume(){
        return s.canResume();
    }
    public boolean canQuit(){
        return s.canQuit();
    }
    public boolean canDeinstall(){
        return s.canDeinstall();
    }
    public boolean canDelete(){
        return s.canDelete();
    }
    public boolean canSell(){ return s.canSell(); }
    public boolean canLend(){
        return s.canLend();
    }
    public boolean canTakeBack(){ return s.canTakeBack(); }
    public boolean canUpdate(){
        return s.canUpdate();
    }
}
