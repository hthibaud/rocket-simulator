package com.rocketsim.core;

import java.util.ArrayList;
import java.util.List;

import com.rocketsim.models.booster.Booster;
import com.rocketsim.models.capsule.Capsule;
import com.rocketsim.models.launcher.Launcher;

public class Builder {
    private String rocketName;
    private Launcher selectedLauncher;
    private Capsule selectedCapsule;
    private List<Booster> selectedBoosters = new ArrayList<>();

    public void setName(String userRocketName) { 
        this.rocketName = userRocketName; 
    }
    
    public boolean addLauncherToRocket(Launcher launcher) {
        if (this.selectedLauncher != null) {
            return false;
        } else {
            this.selectedLauncher = launcher;
            return true;
        }
    }

    public boolean addCapsuleToRocket(Capsule capsule) {
        if (this.selectedCapsule != null) {
            return false;
        } else {
            this.selectedCapsule = capsule;
            return true;
        }
    }

    public void addBoosterToRocket(Booster booster) {
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
        this.rocketName = null;
        
        return myRocket;
    }

    public List<Booster> getSelectedBoosters(){
        return selectedBoosters;
    }

    // public void reset() {
    //     this.selectedLauncher = null;
    //     this.selectedCapsule = null;
    //     this.selectedBoosters = new ArrayList<>();
    //     this.rocketName = null;
    // }
}
