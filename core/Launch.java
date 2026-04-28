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

    public double calculateMissionCost(Rocket myRocket, Mission myMission) {
        double fuelNeeded = myMission.calculateFuelNeeded(myRocket, myMission);
        return myRocket.getTotalPrice() + (fuelNeeded * 1200);
    }

    public String isMissionSuccessful(Rocket myRocket, Mission myMission) {
        String verdictMessage;
        if (!verifyMissionCompatibility(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule had to be habitated for this mission.";
        } else if (!verifyFuel(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had only had " + myRocket.getTotalFuel() + " tons of fuel but you needed " + myMission.calculateFuelNeeded(myRocket, myMission) + " tons of fuel for this mission.";
        } else if (!verifyTotalWeight(myRocket, myMission)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule's weight is " + myRocket.getCapsule().getWeight() + "tons, but your rocket can only handle" + myRocket.getLauncher().getPayload() + "tons.";
        } else if (!verifyNbBoosters(myRocket)) {
            verdictMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had a maximum of " + myRocket.getLauncher().getMaxBoosters() + "boosters ot attach, but you attached" + myRocket.getNbBoosters(myRocket) + "boosters.";
        } else if (verifyMissionCompatibility(myRocket, myMission) && verifyFuel(myRocket, myMission) && verifyTotalWeight(myRocket, myMission) && verifyNbBoosters(myRocket)) {
            if (Math.random() < 0.05) {
                return "Report: Failure. CAUSE: Unforeseen technical issue.";
            } else {
                verdictMessage = "Your mission to " + myMission.getName() + " is a SUCCESS! This mission cost " + calculateMissionCost(myRocket, myMission) + "€";
            }
        } else {
            verdictMessage = "Problem here.";
        }
        return "Report of the " + date + ": " + verdictMessage;
    }

    public boolean verifyFuel(Rocket myRocket, Mission myMission) {
        return (myMission.calculateFuelNeeded(myRocket, myMission) <= myRocket.getTotalFuel());
    }

    public boolean verifyTotalWeight(Rocket myRocket, Mission myMission) {
        return (myRocket.getCapsule().getWeight() <= myRocket.getLauncher().getPayload());
    }

    public boolean verifyNbBoosters(Rocket myRocket) {
        return (myRocket.getNbBoosters(myRocket) <= myRocket.getMaxBoosters());
    }

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
