package core;

import java.util.List;
import models.booster.Booster;
import models.capsule.Capsule;
import models.launcher.Launcher;

public class Rocket {

    private final String name;
    private final Launcher launcher; 
    private final Capsule capsule;
    private final List<Booster> boosters;

    public Rocket(String name, Launcher launcher, Capsule capsule, List<Booster> boosters) {
        this.name = name;
        this.launcher = launcher;
        this.capsule = capsule;
        this.boosters = boosters;
    }

    public int getTotalPrice() {

        int total = 0;

        total += launcher.getPrice();

        total += capsule.getPrice();

        for (Booster b : boosters) {
            total += b.getPrice();
        }

        return total;
    }

    @Override
    public String toString(){
        
        return "Your rocket: " + this.name + "\n" + this.launcher.toString() 
        + "\n" + this.capsule.toString() 
        + "\n" + this.boosters.toString() 
        + "\nBudget of you rocket " + getTotalPrice() + "Millions€";
    }
}
