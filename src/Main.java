import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = "";
        Scanner in = new Scanner(System.in);

        Game G1 = new Game("Minecraft", "15");
        Game G2 = new Game("Dark Souls", "50");
        Game active = G1;

        CommandController CC = new CommandController();
        //CC.printCommands();

        System.out.println("Welcome to our StateFulSteam Store :D");

        label:
        while (true) {
            input = in.nextLine().toLowerCase();

            if (!CC.executeCommand(input, active)) { //if not command by user it must be admin functionality
                switch (input) {
                    case "exit":
                        break label;
                    case "undo":
                        CC.undoCommand();
                        break;
                    case "help":
                        CC.printCommands();
                        break;
                    case "change":
                        if(active == G1){
                            active = G2;
                        }
                        else {
                            active = G1;
                        }
                        break;
                }
            }
        }


    }

}
