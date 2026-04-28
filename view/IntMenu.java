package view;

import java.util.Scanner;

public class IntMenu {

    static Scanner scanner = new Scanner(System.in);
    static ASCII ascii = new ASCII();
    
    public void startMenu(){
        System.out.println("################# WELCOME TO YOUR ROCKET SIMULATOR #################");
        System.out.println (ascii.ASCIIRocket());
        System.out.println ("Start");
        scanner.nextLine();
    }

        public void mainMenu(){
        System.out.println("################# MAIN MENU #################");
        scanner.nextLine();
    }
}
