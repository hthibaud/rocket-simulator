package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.booster.Booster;
import models.capsule.Capsule;
import models.launcher.Launcher;
import models.mission.Mission;
import utils.ASCII;
import utils.Catalog;
import utils.SoundManager;
import utils.utils;

public class Simulator {

    static Builder builder = new Builder();
    private Rocket myRocket;
    private Mission myMission;
    static Scanner scanner = new Scanner(System.in);
    static ASCII ascii = new ASCII();
    static Catalog catalog = new Catalog();
    private final List<String> reports = new ArrayList<>();

    
    //starts the first menu with a rocket ASCII art
    public void startMenu(){
        playBackgroundMusic();
        utils.clearConsole();
        System.out.println(ascii.ASCIIRocketSimu());
        System.out.println (ascii.ASCIIRocket());
        System.out.println ("Start?");
        scanner.nextLine();
    }

        //starts the main menu to choose what you want to do
        public void mainMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIMainMenu());
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

    //all missions print
    public void missionsMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIMissions());
        System.out.println("\n1. "+ catalog.getOrbit().toString());
        System.out.println("\n2. "+ catalog.getISS().toString());
        System.out.println("\n3. "+ catalog.getMoon().toString());
        System.out.println("\n4. "+ catalog.getMars().toString());
        System.out.println("\n5. "+ catalog.getSecretMission().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        mainMenu();
    }

    //all components print
    public void componentsMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIComponents());
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

    //build the rocket menu, with all launchers, capsules, and boosters
    public void buildRocketMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIBuild());
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

    //launches the rocket if you have one (you have to choose a mission to actually launch the rocket)
    public void launchRocket(){
        utils.clearConsole();
        if (myRocket == null) {
        System.out.println(ascii.ASCIINope());
        System.out.println("Build a rocket first!");
        scanner.nextLine();
        mainMenu();
        }
        missionChoiceMenu();
    }


    //all launchers print
    public void launchersMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIILaunchers());
        System.out.println("\n1. "+ catalog.getFalcon9().toString());
        System.out.println("\n2. "+ catalog.getArianeV().toString());
        System.out.println("\n3. "+ catalog.getSaturneV().toString());
        System.out.println("\n4. "+ catalog.getSLS().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        componentsMenu();
    }

    //menu to build using the available launchers
    public void launchersBuildMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIILaunchers());
        System.out.println("\n(for build)");
        System.out.println("\n1. "+ catalog.getFalcon9().toString());
        System.out.println("\n2. "+ catalog.getArianeV().toString());
        System.out.println("\n3. "+ catalog.getSaturneV().toString());
        System.out.println("\n4. "+ catalog.getSLS().toString());
        System.out.println("\n5. Back");

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

    //all capsules print
    public void capsulesMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIICapsules());
        System.out.println("\n1. "+ catalog.getCargoDragon().toString());
        System.out.println("\n2. "+ catalog.getCrewDragon().toString());
        System.out.println("\n3. "+ catalog.getApollo().toString());
        System.out.println("\n4. "+ catalog.getOrion().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        componentsMenu();
    }

    //menu to build using the available capsule
    public void capsulesBuildMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIICapsules());
        System.out.println("\n(for build)");
        System.out.println("\n1. "+ catalog.getCargoDragon().toString());
        System.out.println("\n2. "+ catalog.getCrewDragon().toString());
        System.out.println("\n3. "+ catalog.getApollo().toString());
        System.out.println("\n4. "+ catalog.getOrion().toString());
        System.out.println("\n5. Back");

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

    //all boosters print
    public void boostersMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIBoosters());
        System.out.println("\n1. "+ catalog.getBE3().toString());
        System.out.println("\n2. "+ catalog.getEAP().toString());
        System.out.println("\n3. "+ catalog.getSRB().toString());

        System.out.println("\n(press enter to go back)");
        scanner.nextLine();
        componentsMenu();
    }

    //menu to build using the available boosters
    public void boostersBuildMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIBoosters());
        System.out.println("\n(for build)");
        System.out.println("\n1. "+ catalog.getBE3().toString());
        System.out.println("\n2. "+ catalog.getEAP().toString());
        System.out.println("\n3. "+ catalog.getSRB().toString());
        System.out.println("\n4. Back");

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

    //choosing mission menu
    public void missionChoiceMenu(){
        playClickSound();
        utils.clearConsole();
        System.out.println(ascii.ASCIIChooseMission());
        System.out.println("\n1. "+ catalog.getOrbit().toString());
        System.out.println("\n2. "+ catalog.getISS().toString());
        System.out.println("\n3. "+ catalog.getMoon().toString());
        System.out.println("\n4. "+ catalog.getMars().toString());
        System.out.println("\n5. "+ catalog.getSecretMission().toString());

        System.out.println("\n6. Back");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> confirmMissionChoice(catalog.getOrbit());
            case "2" -> confirmMissionChoice(catalog.getISS());
            case "3" -> confirmMissionChoice(catalog.getMoon());
            case "4" -> confirmMissionChoice(catalog.getMars());
            case "5" -> confirmMissionChoice(catalog.getSecretMission());
            case "6" -> mainMenu();
            default -> missionChoiceMenu();

        }
        scanner.nextLine();
        mainMenu();
    }

    //confirmation print for launcher choice
    public void confirmLauncherChoice(Launcher launcher){
        playClickSound();
        System.out.println("Confirm choice ? : " + launcher.getName());
        System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                playClickSound();
                utils.clearConsole();
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

    //confirmation print for capsule choice
    public void confirmCapsuleChoice(Capsule capsule){
        playClickSound();
        System.out.println("Confirm choice ? : " + capsule.getName());
        System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                playClickSound();
                utils.clearConsole();
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

    //confirmation print for booster choice
    public void confirmBoosterChoice(Booster booster){
        playClickSound();
        System.out.println("Confirm choice ? : " + booster.getName());
                System.out.println("(type yes or no)");
        String choice = scanner.nextLine();
        switch(choice){
            case "yes" -> {
                playClickSound();
                utils.clearConsole();
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

    //confirmation print for mission choice
    public void confirmMissionChoice(Mission mission){
        System.out.println("Confirm choice ? : " + mission.getName());
        System.out.println("(type yes or no)");
        String choice = scanner.nextLine();

        switch(choice){
            case "yes" -> {
                playClickSound();
                this.myMission = mission;
                startLaunch();
            }
            case "no" -> {
                missionChoiceMenu();
            }
            default -> {
                confirmMissionChoice(mission);
            }
        }
    }

    //asks for the name of your rocket and builds it using the builder
    public Rocket finishRocket(){
        playClickSound();
        utils.clearConsole();
        System.out.println("How do you want to name your rocket?");
        String name = scanner.nextLine();
        builder.setName(name);

        this.myRocket = builder.build();

        if (myRocket == null){
            playFailSound();
            System.out.println(ascii.ASCIINope());
            System.out.println("You can't build your rocket, you missed some parts. (press enter to continue)");
            scanner.nextLine();
            buildRocketMenu();
            return null;
        }
        playSuccessSound();
        playBuildSound();
        System.out.println(ascii.ASCIISuccess());
        utils.clearConsole();
        System.out.println("\nYour rocket " + name + " is ready!");
        System.out.println(myRocket.toString());
        System.out.println("(press enter to return to menu)");
        scanner.nextLine();
        mainMenu();

        return myRocket;
    }

    //starts the launch of the rocket with a 3,2,1 countdown
    public void startLaunch(){
        utils.clearConsole();

        Launch launch = new Launch(myRocket, myMission);

        playBeepSound();
        System.out.println("Your mission is launched in 3...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        playBeepSound();
        utils.clearConsole();
        System.out.println("Your mission is launched in 2...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        playBeepSound();
        utils.clearConsole();
        System.out.println("Your mission is launched in 1...    (press enter to see the result)");
        scanner.nextLine();
        playLaunchSound();
        String verdict = launch.isMissionSuccessful(myRocket, myMission);
        if (myMission.getName().equals("Secret mission")){
            playLaunchSound();
            utils.animateTimeTravel();
            System.out.println("(press enter to see the result)");
            scanner.nextLine();
            playImpactSound();
            utils.clearConsole();
            System.out.println(verdict);
        } else {
        System.out.println(verdict);
        reports.add(verdict);
        System.out.println("\n(press enter to return to main menu)");
        scanner.nextLine();
        mainMenu();
        }
    }

    //prints all the previous launches
    public void historyMenu(){
        playClickSound();
        System.out.println(ascii.ASCIIHistory());
        if (reports.isEmpty()){
            utils.clearConsole();
            System.out.println("You don't have any report yet.");
            System.out.println("\n(press enter to return to main menu)");
            scanner.nextLine();
            mainMenu();
        } else {
            int nbReports = 0;
            for (String r : reports){
                nbReports++;
                System.out.println("\n" + nbReports + ". " + r);
            }
            System.out.println("\n(press enter to return to main menu)");
            scanner.nextLine();
            mainMenu();
        }
    }

    //Plays launch sound
    public static void playLaunchSound(){
        SoundManager.playSound("/utils/sounds/rocketLaunchSFX.wav");
    }

    //Plays click sound
    public static void playClickSound(){
        SoundManager.playSound("/utils/sounds/clickSFX.wav");
    }

    //Plays success sound (build)
    public static void playSuccessSound(){
        SoundManager.playSound("/utils/sounds/successSFX.wav");
    }

    //Plays fail sound (build)
    public static void playFailSound(){
        SoundManager.playSound("/utils/sounds/failSFX.wav");
    }

    //Plays impact sound
    public static void playImpactSound(){
        SoundManager.playSound("/utils/sounds/impactSFX.wav");
    }

    //Plays build sound
    public static void playBuildSound(){
        SoundManager.playSound("/utils/sounds/buildSFX.wav");
    }

    //Plays beep sound
    public static void playBeepSound(){
        SoundManager.playSound("/utils/sounds/beepSFX.wav");
    }

    //Starts background music
    public static void playBackgroundMusic(){
        SoundManager.startBackgroundMusic("/utils/sounds/FairyTherapy-This_is_space.wav");
    }

    //Stops background music
    public static void stopBackgroundMusic(){
        SoundManager.stopMusic();
    }

    //stops the music and quits the simulator
    public void quit(){
        stopBackgroundMusic();
        utils.clearConsole();
        System.out.println("Bye!");
        System.exit(0);
    }
}
