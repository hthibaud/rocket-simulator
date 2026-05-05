package com.rocketsim.models.mission;

import com.rocketsim.core.Rocket;

public abstract class Mission {

    protected String name;
    protected boolean mustBeManned;
    protected long distance;
    protected String duration;
    protected double fuelCoefficient;

    public Mission(String name, boolean mustBeManned, long distance, String duration, double fuelCoefficient){
        this.name = name;
        this.mustBeManned = mustBeManned;
        this.distance = distance;
        this.duration = duration;
        this.fuelCoefficient = fuelCoefficient;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

    public boolean needsHabitedCapsule() {
        return mustBeManned;
    }

   public double calculateFuelNeeded(Rocket myRocket, Mission myMission){
        return (myRocket.getTotalWeight() * myMission.distance * myMission.fuelCoefficient) /1000;
    }
    
    @Override
    public String toString(){
        String mustBeManned2;

        if (mustBeManned == true){
            mustBeManned2 = "yes";
        } else {
            mustBeManned2 = "no";
        }
        return 
        "\n   Must be manned: " + mustBeManned2
        + "\n   Distance: " + distance + " km"
        + "\n   Duration: " + duration
        + "\n   Fuel Coefficient: " + fuelCoefficient
        + "\n   Price: depends on your rocket building choices.";  
    }
}
