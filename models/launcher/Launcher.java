package models.launcher;

public abstract class Launcher {

    protected String name;
    protected int price;
    protected int maxFuel;
    protected int payload;
    protected int maxBoosters;
    protected boolean mustBeManned;

    public Launcher(String name, int price, int maxFuel, int payload, int maxBoosters, boolean mustBeManned){
        this.name = name;
        this.price = price;
        this.maxFuel = maxFuel;
        this.payload = payload;
        this.maxBoosters = maxBoosters;
        this.mustBeManned = mustBeManned;
    }
    
    //returns the price of the launcher
    public int getPrice() {
         return price; 
        }

    //returns the max fuel of the launcher
    public int getMaxFuel() {
         return maxFuel; 
        }

    //returns the name of the launcher
    public String getName(){
        return name;
    }

    //returns the weight of the launcher
    public double getWeight(){
        return maxFuel;
    }


    //returns the payload of the launcher
    public int getPayload(){
        return payload;
    }

    //returns the maximum number of boosters the launcher can handle
    public int getMaxBoosters(){
        return maxBoosters;
    }


    //toString method for the launcher
    @Override
    public String toString(){
        String mustBeManned2;

        if (mustBeManned == true){
            mustBeManned2 = "yes";
        } else {
            mustBeManned2 = "no";
        }
        return 
        getName() 
        + "\nSpecs: " 
        + "\n   Must be manned: " + mustBeManned2
        + "\n   Payload: " + payload + " tons"
        + "\n   Max fuel: " + maxFuel + " tons"
        + "\n   Number max of boosters: " + maxBoosters
        + "\n   Price: " + price + "Millions€";  
    }
}