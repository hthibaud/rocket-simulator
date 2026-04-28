package simulator;

import java.util.Scanner;
import utils.utils;

public class IntMenu {

    static Scanner scanner = new Scanner(System.in);
    static ASCII ascii = new ASCII();
    
    public void startMenu(){
        System.out.println("################# WELCOME TO YOUR ROCKET SIMULATOR #################");
        System.out.println (ascii.ASCIIRocket());
        System.out.println ("Start?");
        scanner.nextLine();
    }

        public void mainMenu(){
        System.out.println("################# MAIN MENU #################");
        System.out.println ("Launch test");
        scanner.nextLine();
        launchRocket();
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
}
