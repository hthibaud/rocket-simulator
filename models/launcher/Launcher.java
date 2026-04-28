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

    public int getPrice() {
         return price; 
        }
    public int getMaxFuel() {
         return maxFuel; 
        }
    public String getName(){
        return name;
    }

    public double getWeight(){
        return maxFuel;
    }

    public int getPayload(){
        return payload;
    }

    public int getMaxBoosters(){
        return maxBoosters;
    }


    @Override
    public String toString(){
        String mustBeManned2;

        if (mustBeManned == true){
            mustBeManned2 = "yes";
        } else {
            mustBeManned2 = "no";
        }
        return 
        "\n" 
        + getName() 
        + "\nSpecs: " 
        + "\n   Must be manned: " + mustBeManned2
        + "\n   Payload: " + payload + " tons"
        + "\n   Max fuel: " + maxFuel + " tons"
        + "\n   Number max of boosters: " + maxBoosters
        + "\n   Price: " + price + "€";  
    }
}