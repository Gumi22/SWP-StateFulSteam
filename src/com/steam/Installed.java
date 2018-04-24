package com.steam;

import java.util.Random;

public class Installed extends State {
    InstalledState state = null;

    public Installed(){
        Random rnd = new Random(12345);
        if(rnd.nextBoolean()){
            state = new Outdated();
        }
        else{
            state = new UpToDate();
        }
    }

    protected void setState(InstalledState i){
        state = i;
    }

    @Override
    public void start(Game g){
        this.state.start(g, this);
    }

    @Override
    public void update(Game g) {
        this.state.update(g, this);
    }

    @Override
    public void deinstall(Game g) {
        System.out.println("Deinstalling ... please wait ... deinstalled :D");
        g.setState(new Downloaded());
    }

    @Override
    public void delete(Game g) {
        deinstall(g);
        g.delete();
    }

    @Override
    public void sell(Game g) {
        deinstall(g);
        g.sell();
    }

    @Override
    public void lend(Game g) {
        System.out.println("You've lent you Game to Kevin, make sure you get it back!");
        g.setState(new Lent(this));
    }
}
