public class ButtonEnabledDependingOnSelectedGameMediator {

    MainController myMC;

    public ButtonEnabledDependingOnSelectedGameMediator(MainController mc){
        myMC = mc;
    }

    public void Update(Game g){
        myMC.buyBtn.setVisible(new Buy().canExecute(g));
        myMC.buyForAFriendBtn.setVisible(new BuyForAFriend().canExecute(g));
        myMC.deinstallBtn.setVisible(new Deinstall().canExecute(g));
        myMC.deleteBtn.setVisible(new Delete().canExecute(g));
        myMC.downloadBtn.setVisible(new Download().canExecute(g));
        myMC.installBtn.setVisible(new Install().canExecute(g));
        myMC.lendBtn.setVisible(new Lend().canExecute(g));
        myMC.pauseBtn.setVisible(new Pause().canExecute(g));
        myMC.quitBtn.setVisible(new Quit().canExecute(g));
        myMC.oneClickPlayBtn.setVisible(new OneClickPlay().canExecute(g));
        myMC.resumeBtn.setVisible(new Resume().canExecute(g));
        myMC.sellBtn.setVisible(new Sell().canExecute(g));
        myMC.showBtn.setVisible(new Show().canExecute(g));
        myMC.startBtn.setVisible(new Start().canExecute(g));
        myMC.takeBackBtn.setVisible(new TakeBack().canExecute(g));
        myMC.updateBtn.setVisible(new Update().canExecute(g));
    }
}
