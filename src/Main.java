import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = "";
        Scanner in = new Scanner(System.in);
        Game G = new Game("Minecraft", "15");
        CommandController CC = new CommandController();
        CC.printCommands();

        System.out.println("Welcome to our StateFulSteam Store :D");
        label:
        while (true) {
            input = in.nextLine();

            switch (input) {
                case "exit":
                    break label;
                case "show":
                    System.out.println("Name: " + G.getName());
                    System.out.println("Price: " + G.getPrice());
                    System.out.println("State: " + G.getState());
                    break;
                case "buy":
                    G.buy();
                    break;
                case "download":
                    G.download();
                    break;
                case "install":
                    G.install();
                    break;
                case "start":
                    G.start();
                    break;
                case "pause":
                    G.pause();
                    break;
                case "resume":
                    G.resume();
                    break;
                case "quit":
                    G.quit();
                    break;
                case "deinstall":
                    G.deinstall();
                    break;
                case "delete":
                    G.delete();
                    break;
                case "sell":
                    G.sell();
                    break;
                case "lend":
                    G.lend();
                    break;
                case "update":
                    G.update();
                    break;
            }
        }

    }
}
