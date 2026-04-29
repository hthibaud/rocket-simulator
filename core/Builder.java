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
    
    public boolean addLauncherToRocket(Launcher launcher) {
        if (this.selectedLauncher != null) {
            utils.clearConsole();
            System.out.println("You already have a " + selectedLauncher.getName() + " on your rocket.");
            return false;
        } else {
            this.selectedLauncher = launcher;
            utils.clearConsole();
            System.out.println(launcher.getName() + " added to your rocket!");
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
            utils.clearConsole();
            System.out.println(capsule.getName() + " added to your rocket!");
            return true;
        }
    }

    public void addBoosterToRocket(Booster booster) {
        utils.clearConsole();
        System.out.println("\n" + booster.getName() + " added to your rocket!");
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