import core.Rocket;
import java.util.ArrayList;
import java.util.List;
import models.booster.Booster;
import models.booster.EAP;
import models.capsule.CargoDragon;
import models.launcher.ArianeV;
import utils.utils;
import view.IntMenu;

public class Program {
    public static void main(String[] args) {

        IntMenu menu = new IntMenu();
        ArianeV myAriane = new ArianeV();
        CargoDragon myCargoDragon = new CargoDragon();
        EAP myEAP1 = new EAP();
        EAP myEAP2 = new EAP();
        List<Booster> myBoosters = new ArrayList<>();
        myBoosters.add(myEAP1);
        myBoosters.add(myEAP2);
        
        Rocket myRocket = new Rocket("Rocket1", myAriane, myCargoDragon, myBoosters);

        utils.clearConsole();
        menu.startMenu();
        menu.mainMenu();
        System.out.println(myRocket.toString());
    }
}
