package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.booster.Booster;
import models.capsule.Capsule;
import models.launcher.Launcher;
import utils.ASCII;
import utils.Catalog;
import utils.utils;

public class Simulator {

    static Builder builder = new Builder();
    static Scanner scanner = new Scanner(System.in);
    static ASCII ascii = new ASCII();
    static Catalog catalog = new Catalog();
    private final List<String> reports = new ArrayList<>();

    
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

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> missionsMenu();
            case "2" -> componentsMenu();
            case "3" -> buildRocketMenu();
            case "4" -> launchRocket();
            case "5" -> historyMenu();
            case "6" -> quit();
            default -> mainMenu();
        }

    }

    public void missionsMenu(){
        utils.clearConsole();
        System.out.println("################# MISSIONS #################");
        System.out.println("\n1. "+ catalog.getOrbit().toString());
        System.out.println("\n2. "+ catalog.getISS().toString());
        System.out.println("\n3. "+ catalog.getMoon().toString());
        System.out.println("\n4. "+ catalog.getMars().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        mainMenu();
    }

    public void componentsMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE COMPONENTS #################");
        System.out.println("1. Launchers");
        System.out.println("2. Capsules");
        System.out.println("3. Boosters");
        System.out.println("4. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> launchersMenu();
            case "2" -> capsulesMenu();
            case "3" -> boostersMenu();
            case "4" -> mainMenu();
            default -> componentsMenu();

        }
    }

    public void buildRocketMenu(){
        utils.clearConsole();
        System.out.println("################# BUILD YOUR ROCKET #################");
        System.out.println("1. Launchers");
        System.out.println("2. Capsules");
        System.out.println("3. Boosters");
        System.out.println("4. Finish Rocket");
        System.out.println("5. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> launchersBuildMenu();
            case "2" -> capsulesBuildMenu();
            case "3" -> boostersBuildMenu();
            case "4" -> finishRocket();
            case "5" -> mainMenu();
            default -> buildRocketMenu();

        }
    }

    public void launchRocket(){
        utils.clearConsole();
        if (myRocket == null) {
        System.out.println("Build a rocket first!");
        scanner.nextLine();
        mainMenu();
    }
        System.out.println("Your mission is launched in 3...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        utils.clearConsole();
        System.out.println("Your mission is launched in 2...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
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
        scanner.nextLine();
        mainMenu();
    }

    public void launchersBuildMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE LAUNCHERS (for build) #################");
        System.out.println("1. "+ catalog.getFalcon9().toString());
        System.out.println("2. "+ catalog.getArianeV().toString());
        System.out.println("3. "+ catalog.getSaturneV().toString());
        System.out.println("4. "+ catalog.getSLS().toString());
        System.out.println("5. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> confirmLauncherChoice(catalog.getFalcon9());
            case "2" -> confirmLauncherChoice(catalog.getArianeV());
            case "3" -> confirmLauncherChoice(catalog.getSaturneV());
            case "4" -> confirmLauncherChoice(catalog.getSLS());
            case "5" -> buildRocketMenu();
            default -> launchersBuildMenu();

        }
        scanner.nextLine();
        buildRocketMenu();
    }

    public void capsulesMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE CAPSULES #################");
        System.out.println("1. "+ catalog.getCargoDragon().toString());
        System.out.println("2. "+ catalog.getCrewDragon().toString());
        System.out.println("3. "+ catalog.getApollo().toString());
        System.out.println("4. "+ catalog.getOrion().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        mainMenu();
    }

    public void capsulesBuildMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE CAPSULES (for build) #################");
        System.out.println("1. "+ catalog.getCargoDragon().toString());
        System.out.println("2. "+ catalog.getCrewDragon().toString());
        System.out.println("3. "+ catalog.getApollo().toString());
        System.out.println("4. "+ catalog.getOrion().toString());
        System.out.println("5. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> confirmCapsuleChoice(catalog.getCargoDragon());
            case "2" -> confirmCapsuleChoice(catalog.getCrewDragon());
            case "3" -> confirmCapsuleChoice(catalog.getApollo());
            case "4" -> confirmCapsuleChoice(catalog.getOrion());
            case "5" -> buildRocketMenu();
            default -> capsulesBuildMenu();

        }
        scanner.nextLine();
        buildRocketMenu();
    }

    public void boostersMenu(){
        utils.clearConsole();
        System.out.println("################# AVAILABLE BOOSTERS #################");
        System.out.println("1. "+ catalog.getBE3().toString());
        System.out.println("2. "+ catalog.getEAP().toString());
        System.out.println("3. "+ catalog.getSRB().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        mainMenu();
    }

    public void boostersBuildMenu(){
                utils.clearConsole();
        System.out.println("################# AVAILABLE BOOSTERS (for build) #################");
        System.out.println("1. "+ catalog.getBE3().toString());
        System.out.println("2. "+ catalog.getEAP().toString());
        System.out.println("3. "+ catalog.getSRB().toString());
        System.out.println("4. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> confirmBoosterChoice(catalog.getBE3());
            case "2" -> confirmBoosterChoice(catalog.getEAP());
            case "3" -> confirmBoosterChoice(catalog.getSRB());
            case "4" -> buildRocketMenu();
            default -> boostersBuildMenu();

        }
        scanner.nextLine();
        buildRocketMenu();
    }

    public void confirmLauncherChoice(Launcher launcher){
        System.out.println("Confirm choice ? : " + launcher.getName());
        System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                builder.addLauncherToRocket(launcher);
            }
            case "no" -> {
                launchersBuildMenu();
            }
            default -> {
                confirmLauncherChoice(launcher);
            }
        }
    }

    public void confirmCapsuleChoice(Capsule capsule){
        System.out.println("Confirm choice ? : " + capsule.getName());
        System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                builder.addCapsuleToRocket(capsule);
            }
            case "no" -> {
                launchersBuildMenu();
            }
            default -> {
                confirmCapsuleChoice(capsule);
            }
        }
    }

    public void confirmBoosterChoice(Booster booster){
        System.out.println("Confirm choice ? : " + booster.getName());
                System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                builder.addBoosterToRocket(booster);
            }
            case "no" -> {
                launchersBuildMenu();
            }
            default -> {
                confirmBoosterChoice(booster);
            }
        }
    }

    public Rocket finishRocket(){

        utils.clearConsole();
        System.out.println("How do you want to name your rocket?");
        String name = scanner.nextLine();
        builder.setName(name);

        return builder.build();
    }

    public void historyMenu(){
        // if (launch.getReports().isEmpty()){
        //     System.out.println("You don't have any report yet.");
        // }
    }

    public void quit(){
        utils.clearConsole();
        System.out.println("Bye!");
    }
}
