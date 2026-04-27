package core;

import java.sql.SQLData;

public class Launch {
   
    private String date;
    private double totalCost;
    private boolean verdict;
    private String reason;

    public static boolean verifyMissionCompatibility(){
        return true;
    }

    public static String generateReport(){
        String report = "";
        return report;
    } 

    public static SQLData addReportToDataBase(){
        return null;
    }
}
