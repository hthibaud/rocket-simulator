package core;

import models.mission.Mission;

public class Launch {

    private final Rocket rocket;
    private final Mission mission;
    private final String date;

    public Launch(Rocket rocket, Mission mission) {
        this.date = java.time.LocalDate.now().toString();
        this.rocket = rocket;
        this.mission = mission;
    }

    //calculates the cost of the mission
    public double calculateMissionCost(Rocket myRocket, Mission myMission) {
        double fuelNeeded = myMission.calculateFuelNeeded(myRocket, myMission);
        return myRocket.getTotalPrice() + ((fuelNeeded * 1200) / 1_000_000);
    }

    //verifies every possibility that the mission could fail and returns the report verdict message
    public String isMissionSuccessful(Rocket myRocket, Mission myMission) {
        String verdictMessage;
        if ("Secret mission".equals(mission.getName())){
            verdictMessage = "You never came back.";
        } else if (!verifyMissionCompatibility(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule had to be habitated for this mission.";
        } else if (!verifyFuel(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had only had " + myRocket.getTotalFuel() + " tons of fuel but you needed " + myMission.calculateFuelNeeded(myRocket, myMission) + " tons of fuel for this mission.";
        } else if (!verifyTotalWeight(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule's weight is " + myRocket.getCapsule().getWeight() + "tons, but your rocket can only handle" + myRocket.getLauncher().getPayload() + "tons.";
        } else if (!verifyNbBoosters(myRocket)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had a maximum of " + myRocket.getLauncher().getMaxBoosters() + " boosters ot attach, but you attached " + myRocket.getNbBoosters(myRocket) + " of them.";
        } else if (verifyMissionCompatibility(myRocket, myMission) && verifyFuel(myRocket, myMission) && verifyTotalWeight(myRocket, myMission) && verifyNbBoosters(myRocket)) {
            if (Math.random() < 0.05) {
                return "Report: Failure. CAUSE: Unforeseen technical issue.";
            } else {
                verdictMessage = "Your mission to " + myMission.getName() + " is a SUCCESS! This mission cost " + calculateMissionCost(myRocket, myMission) + " Millions€";
            }
        } else {
            verdictMessage = "Problem here.";
        }
        return "Report of the " + date + ": " + verdictMessage;
    }

    //verifies if there's enough fuel for the launch
    public boolean verifyFuel(Rocket myRocket, Mission myMission) {
        return (myMission.calculateFuelNeeded(myRocket, myMission) <= myRocket.getTotalFuel());
    }

    //verifies if the capsule's weight is ok for the payload of the launcher
    public boolean verifyTotalWeight(Rocket myRocket, Mission myMission) {
        return (myRocket.getCapsule().getWeight() <= myRocket.getLauncher().getPayload());
    }

    //verifies if there are too many boosters for the current launcher
    public boolean verifyNbBoosters(Rocket myRocket) {
        return (myRocket.getNbBoosters(myRocket) <= myRocket.getMaxBoosters());
    }

    //verifies if the mission selected is compatible with the rocket built (needs to be manned or not)
    public boolean verifyMissionCompatibility(Rocket myRocket, Mission myMission) {

        if (myRocket.getCapsule().getIsManned() == false) {

            switch (myMission.getName()) {
                case "ISS" -> {
                    return false;
                }
                case "Moon" -> {
                    return false;
                }
                case "Mars" -> {
                    return false;
                }
                case "Orbit" -> {
                    return true;
                }
            }
        }
        return true;
    }
}
