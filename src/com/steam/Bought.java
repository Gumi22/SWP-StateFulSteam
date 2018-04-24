package com.steam;

public class Bought extends State{

    @Override
    public void download(Game g) {
        System.out.println("Downloading ... please wait ... finished downloading :D");
        g.setState(new Downloaded());
    }

    @Override
    public void install(Game g) {
        download(g);
        g.install();
    }

    @Override
    public void start(Game g) {
        install(g);
        g.start();
    }

    @Override
    public void sell(Game g) {
        System.out.println("You sold your game for " + g.getPrice() + "€!");
        g.setState(new InStore());
    }

    @Override
    public void lend(Game g) {
        System.out.println("You've lent you Game to Kevin, make sure you get it back!");
        g.setState(new Lent(this));
    }
}
