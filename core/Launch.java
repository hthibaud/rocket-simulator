package core;

import java.util.ArrayList;
import java.util.List;

public class Launch {
   
    private String date;
    private double totalCost;
    private boolean verdict;
    private String reason;
    private final List<String> reports = new ArrayList<>();

    public static boolean verifyMissionCompatibility(){
        return true;
    }

    public String generateAndAddReport(){
        String report = "";
        reports.add(report);
        return report;
    } 
}
