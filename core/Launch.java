package core;

import java.util.ArrayList;
import java.util.List;
import models.mission.Mission;

public class Launch {

    private Rocket rocket;
    private Mission mission;
    private boolean success;
    private String date;
    private double totalCost;
    private boolean verdict;
    private String reason;
    private final List<String> reports = new ArrayList<>();

    public Launch(Rocket rocket, Mission mission) {
        this.date = java.time.LocalDate.now().toString();
        this.rocket = rocket;
        this.mission = mission;
    }

    public double calculateMissionCost(Rocket myRocket, Mission myMission) {
        return myRocket.getTotalPrice() + (myRocket.getTotalFuel() * 1200);
    }

    public String generateAndAddReport() {
        String report = "Launch report of the " + date + ": ";
        reports.add(report);
        return report;
    }

    public String isMissionSuccessful(Rocket myRocket, Mission myMission) {
        if (!verifyMissionCompatibility(myRocket, myMission)) {
            return "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule had to be habitated for this mission.";
        } else if (!verifyFuel(myRocket, myMission)) {
            return "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had only had " + myRocket.getTotalFuel() + " tons of fuel but you needed " + myMission.calculateFuelNeeded(myRocket, myMission) + " tons of fuel for this mission.";
        } else if (!verifyTotalWeight(myRocket, myMission)) {
            return "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule's weight is " + myRocket.getCapsule().getWeight() + "tons, but your rocket can only handle" + myRocket.getLauncher().getPayload() + "tons.";
        } else if (!verifyNbBoosters(myRocket)) {
            return "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had a maximum of " + myRocket.getLauncher().getMaxBoosters() + "boosters ot attach, but you attached" + myRocket.getNbBoosters(myRocket) + "boosters.";
        } else if (verifyMissionCompatibility(myRocket, myMission) && verifyFuel(myRocket, myMission) && verifyTotalWeight(myRocket, myMission) && verifyNbBoosters(myRocket)) {
            return "Your mission to " + myMission.getName() + " is a SUCCESS!";
        } else {
            return "Problem here.";
        }
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
