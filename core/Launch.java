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

    // public static boolean verifyMissionCompatibility(){
        
    // }

    public double calculateMissionCost(Rocket myRocket, Mission myMission){
        return myRocket.getTotalPrice() + (myRocket.getTotalFuel() * 1200);
    }

    public String generateAndAddReport(){
        String report = "";
        reports.add(report);
        return report;
    } 
}
