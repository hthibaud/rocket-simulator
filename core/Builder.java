package core;

import java.util.ArrayList;
import java.util.List;
import models.booster.Booster;
import models.capsule.Capsule;
import models.launcher.Launcher;
import utils.utils;

public class Builder {
    private String rocketName;
    private Launcher selectedLauncher;
    private Capsule selectedCapsule;
    private List<Booster> selectedBoosters = new ArrayList<>();

    public void setName(String name) { 
        this.rocketName = name; 
    }

    public String getRocketName(){
        return rocketName;
    }
    
    public boolean addLauncherToRocket(Launcher launcher) {
        if (this.selectedLauncher != null) {
            utils.clearConsole();
            System.out.println("You already have a " + selectedLauncher.getName() + " on your rocket.");
            return false;
        } else {
            this.selectedLauncher = launcher;
            System.out.println("\nLauncher " + launcher.getName() + " added to your rocket!");
            return true;
        }
    }

    public boolean addCapsuleToRocket(Capsule capsule) {
        if (this.selectedCapsule != null) {
            utils.clearConsole();
            System.out.println("You already have a " + capsule.getName() + " on your rocket.");
            return false;
        } else {
            this.selectedCapsule = capsule;
            System.out.println("\nCapsule " + capsule.getName() + " added to your rocket!");
            return true;
        }
    }

    public void addBoosterToRocket(Booster booster) {
        System.out.println("\nBooster " + booster.getName() + " added to your rocket!");
         this.selectedBoosters.add(booster); 
    }

    public Rocket build() {
        if (selectedLauncher == null || selectedCapsule == null) {
            return null; 
        }

        Rocket myRocket = new Rocket(rocketName, selectedLauncher, selectedCapsule, selectedBoosters);
        
        this.selectedLauncher = null;
        this.selectedCapsule = null;
        this.selectedBoosters = new ArrayList<>();
        
        return myRocket;
    }
}