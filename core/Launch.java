package core;

import models.mission.Mission;
import utils.ASCII;


      public class Launch {

        private final Rocket rocket;
        private final Mission mission;
        private final String date;
        private boolean hasDisappeared = false;
        private String lastReport;

        public Launch(Rocket rocket, Mission mission, boolean hasDisappeared) {
            this.date = java.time.LocalDate.now().toString();
            this.rocket = rocket;
            this.mission = mission;
            this.hasDisappeared = hasDisappeared;
        }

        //calculates the cost of the mission
        public double calculateMissionCost(Rocket myRocket, Mission myMission) {
            double fuelNeeded = myMission.calculateFuelNeeded(myRocket, myMission);
            return myRocket.getTotalPrice() + ((fuelNeeded * 1200) / 1_000_000);
        }

        //verifies every possibility that the mission could fail and returns the report verdict message
        public String isMissionSuccessful(Rocket myRocket, Mission myMission) {
            ASCII ascii = new ASCII();
            String verdictMessage;
            String reportMessage = "";

            if (this.hasDisappeared == true) {
                verdictMessage = "You can't go on missions once you discovered the secret. Remember? You never came back.";
            } else if ("Secret mission".equals(myMission.getName())) {
                verdictMessage = "You never came back.";
                this.hasDisappeared = true;

            } else if (!verifyMissionCompatibility(myRocket, myMission)) {
                verdictMessage = ascii.ASCIINope() + "\nYour mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule had to be habitated for this mission.";
                reportMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule had to be habitated for this mission.";
            } else if (!verifyFuel(myRocket, myMission)) {
                verdictMessage = ascii.ASCIINope() + "\nYour mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had only had " + myRocket.getTotalFuel() + " tons of fuel but you needed " + myMission.calculateFuelNeeded(myRocket, myMission) + " tons of fuel for this mission.";
                reportMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had only had " + myRocket.getTotalFuel() + " tons of fuel but you needed " + myMission.calculateFuelNeeded(myRocket, myMission) + " tons of fuel for this mission.";
            } else if (!verifyTotalWeight(myRocket, myMission)) {
                verdictMessage = ascii.ASCIINope() + "\nYour mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule's weight is " + myRocket.getCapsule().getWeight() + "tons, but your rocket can only handle" + myRocket.getLauncher().getPayload() + "tons.";
                reportMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Your capsule's weight is " + myRocket.getCapsule().getWeight() + "tons, but your rocket can only handle" + myRocket.getLauncher().getPayload() + "tons.";
            } else if (!verifyNbBoosters(myRocket)) {
                verdictMessage = ascii.ASCIINope() + "\nYour mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had a maximum of " + myRocket.getLauncher().getMaxBoosters() + " boosters ot attach, but you attached " + myRocket.getNbBoosters(myRocket) + " of them.";
                reportMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: You had a maximum of " + myRocket.getLauncher().getMaxBoosters() + " boosters ot attach, but you attached " + myRocket.getNbBoosters(myRocket) + " of them.";
            } else if (verifyMissionCompatibility(myRocket, myMission) && verifyFuel(myRocket, myMission) && verifyTotalWeight(myRocket, myMission) && verifyNbBoosters(myRocket)) {
                if (Math.random() < 0.05) {
                    verdictMessage = ascii.ASCIINope() + "\nYour mission to " + myMission.getName() + " has been canceled.\n CAUSE: Unforeseen technical issue.";
                    reportMessage = "Your mission to " + myMission.getName() + " has been canceled.\n CAUSE: Unforeseen technical issue.";

                } else {
                    reportMessage = String.format("Your mission to " + myMission.getName() + " is a SUCCESS! This mission cost %.2f Millions€", calculateMissionCost(myRocket, myMission));
                    verdictMessage = String.format(ascii.ASCIISuccess() + "\nYour mission to " + myMission.getName() + " is a SUCCESS! This mission cost %.2f Millions€", calculateMissionCost(myRocket, myMission));
                }
            } else {
                verdictMessage = "Problem here.";
            }
        this.lastReport = "Report of the " + date + ": " + reportMessage + "\nRocket: '" + myRocket.getName() + "'";
        return verdictMessage;
    }

    //returns if the user has disappeared because of the secret mission
    public boolean getHasDisappeared() {
        return hasDisappeared;
    }

    //returns the last report to store it in the reports list
    public String getLastReport() {
    return lastReport;
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
