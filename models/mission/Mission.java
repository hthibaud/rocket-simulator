package models.mission;

import core.Rocket;

public abstract class Mission {

    protected String name;
    protected boolean hasToBeManned;
    protected long distance;
    protected String duration;
    protected double fuelCoefficient;

    public Mission(String name, boolean hasToBeManned, long distance, String duration, double fuelCoefficient){
        this.name = name;
        this.hasToBeManned = hasToBeManned;
        this.distance = distance;
        this.duration = duration;
        this.fuelCoefficient = fuelCoefficient;
    }


    public double calculateFuelNeeded(Rocket myRocket, Mission myMission){
        return (myRocket.getTotalWeight() * myMission.distance * myMission.fuelCoefficient) /1000;
    }
}
