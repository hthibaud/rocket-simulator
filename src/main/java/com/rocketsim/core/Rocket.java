package com.rocketsim.core;

import java.util.List;

import com.rocketsim.models.booster.Booster;
import com.rocketsim.models.capsule.Capsule;
import com.rocketsim.models.launcher.Launcher;

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

    public double getTotalWeight(){
        double totalWeight = 0;
        totalWeight += launcher.getWeight();
        totalWeight += capsule.getWeight();
        for (Booster b : boosters) {
            totalWeight += b.getWeight();
        }
        return totalWeight;
    }

    public int getTotalThrust(){
        int totalThrust = 0;
        for (Booster b : boosters) {
            totalThrust += b.getAdditionalThrust();
        }
        return totalThrust;
    }

    public boolean verifyPayload(){
        return (this.launcher.getPayload() <= this.capsule.getWeight());
    }

    public int getTotalFuel(){
        int launcherFuel = launcher.getMaxFuel();
        int boosterFuel = 0;
        
        for (Booster b : boosters) {
            if (b.getName().equals("BE-3")){
                boosterFuel += 300; 
            } else if (b.getName().equals("EAP")){
                boosterFuel += 3500; 
            } else if (b.getName().equals("SRB")){
                boosterFuel += 6500; 
            }
        }
        return launcherFuel + boosterFuel;
    }
    
    public Capsule getCapsule(){
        return this.capsule;
    }

    public Launcher getLauncher(){
        return this.launcher;
    }

    public int getNbBoosters(Rocket myRocket){
        int nbBoosters = 0;
        for (Booster b : boosters){
            nbBoosters++;
        }
        return nbBoosters;
    }

    public String getBoostersName(){

        String boosterName = "";


        for (Booster b : boosters) {

            boosterName = b.getName();          
        }
        return boosterName;
    }

    public String getBoosterstoString(){
        int totalBoosters = 0;
        if (boosters.isEmpty()){
            return "No booster";
        }
        for (Booster b : boosters) {
            totalBoosters++;
        }
        return totalBoosters + " " + getBoostersName() + " boosters"; 
    }

    public int getMaxBoosters(){
        return this.launcher.getMaxBoosters();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        String boosterDetails = boosters.isEmpty() ? "" : "\n" + boosters.get(0).toString();
        return "Rocket: " + this.name + "\n" + this.launcher.toString() 
        + "\n   " + this.capsule.toString() 
        + "\n\n" + getBoosterstoString() 
        + boosterDetails
        + "\n\nPrice of your rocket: " + getTotalPrice() + "Millions€";
    }
}
