package simulator;

import java.util.Scanner;
import utils.Catalog;
import utils.utils;

public class IntMenu {

    static Scanner scanner = new Scanner(System.in);
    static ASCII ascii = new ASCII();
    static Catalog catalog = new Catalog();
    
    public void startMenu(){
        utils.clearConsole();
        System.out.println("################# WELCOME TO YOUR ROCKET SIMULATOR #################");
        System.out.println (ascii.ASCIIRocket());
        System.out.println ("Start?");
        scanner.nextLine();
    }

        public void mainMenu(){
        utils.clearConsole();
        System.out.println("################# MAIN MENU #################");
        System.out.println("1. See missions");
        System.out.println("2. See available components");
        System.out.println("3. Build your rocket");
        System.out.println("4. Launch your rocket!");
        System.out.println("5. History of your launches");
        System.out.println("6. Quit");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1 -> missionsMenu();
            case 2 -> componentsMenu();
            case 3 -> buildRocketMenu();
            case 4 -> launchRocket();
            case 5 -> historyMenu();
            case 6 -> quit();
        }

    }

    public void missionsMenu(){
        utils.clearConsole();
        System.out.println("################# MISSIONS #################");
        System.out.println("1. "+ catalog.getOrbit().toString());
        System.out.println("2. "+ catalog.getISS().toString());
        System.out.println("3. "+ catalog.getMoon().toString());
        System.out.println("4. "+ catalog.getMars().toString());

        System.out.println("\n(press enter to go back)");
    }

    public void componentsMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE COMPONENTS #################");
        System.out.println("1. Launchers");
        System.out.println("2. Capsules");
        System.out.println("3. Boosters");
        System.out.println("4. Back");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1 -> launchersMenu();
            case 2 -> capsulesMenu();
            case 3 -> boostersMenu();
            case 4 -> mainMenu();

        }
    }

    public void buildRocketMenu(){

    }
    public void launchRocket(){
        utils.clearConsole();
        System.out.println("Your mission is launched in 3...");
        scanner.nextLine();
        utils.clearConsole();
        System.out.println("Your mission is launched in 2...");
        scanner.nextLine();
        utils.clearConsole();
        System.out.println("Your mission is launched in 1...    (press enter to see the result)");
        scanner.nextLine();
    }

    public void launchersMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE LAUNCHERS #################");
        System.out.println("1. "+ catalog.getFalcon9().toString());
        System.out.println("2. "+ catalog.getArianeV().toString());
        System.out.println("3. "+ catalog.getSaturneV().toString());
        System.out.println("4. "+ catalog.getSLS().toString());

        System.out.println("\n(press enter to go back)");
    }

    public void capsulesMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE CAPSULES #################");
        System.out.println("1. "+ catalog.getCargoDragon().toString());
        System.out.println("2. "+ catalog.getCrewDragon().toString());
        System.out.println("3. "+ catalog.getApollo().toString());
        System.out.println("4. "+ catalog.getOrion().toString());

        System.out.println("\n(press enter to go back)");
    }

    public void boostersMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE BOOSTERS #################");
        System.out.println("1. "+ catalog.getBE3().toString());
        System.out.println("2. "+ catalog.getEAP().toString());
        System.out.println("3. "+ catalog.getSRB().toString());

        System.out.println("\n(press enter to go back)");
    }

    public void historyMenu(){
        
    }
    
    public void quit(){
        utils.clearConsole();
        System.out.println("Bye!");
    }
}
