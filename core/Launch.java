package core;

import java.util.ArrayList;
import java.util.List;
import models.mission.Mission;

public class Launch {
   
    private String date;
    private double totalCost;
    private boolean verdict;
    private String reason;
    private final List<String> reports = new ArrayList<>();

    public boolean verifyMissionCompatibility(Rocket myRocket, Mission myMission){

        if (myRocket.getCapsule().getIsManned() == false) {

        switch (myMission.getName()

        ) {
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

    public double calculateMissionCost(Rocket myRocket, Mission myMission){
        return myRocket.getTotalPrice() + (myRocket.getTotalFuel() * 1200);
    }

    public String generateAndAddReport(){
        String report = "";
        reports.add(report);
        return report;
    } 
}
