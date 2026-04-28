import core.Launch;
import core.Rocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.booster.Booster;
import models.booster.EAP;
import models.capsule.CargoDragon;
import models.launcher.ArianeV;
import models.mission.Orbit;
import simulator.IntMenu;
import utils.utils;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        IntMenu menu = new IntMenu();
        ArianeV myAriane = new ArianeV();
        CargoDragon myCargoDragon = new CargoDragon();
        EAP myEAP1 = new EAP();
        EAP myEAP2 = new EAP();
        List<Booster> myBoosters = new ArrayList<>();
        myBoosters.add(myEAP1);
        myBoosters.add(myEAP2);
        
        Rocket myRocket = new Rocket("Rocket1", myAriane, myCargoDragon, myBoosters);
        Orbit myMission = new Orbit();
        Launch launch = new Launch(myRocket, myMission);

        utils.clearConsole();
        menu.startMenu();
        menu.mainMenu();
        //System.out.println(launch.isMissionSuccessful(myRocket, myMission));
        //scanner.nextLine();
        //System.out.println(myRocket.toString());
    }
}
