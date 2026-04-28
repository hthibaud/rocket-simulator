package models.booster;

public class Booster {

    protected String name;
    protected int additionalThrust;
    protected double weight;
    protected int price;

    public Booster(String name, int additionalThrust, double weight, int price) {
        this.name = name;
        this.additionalThrust = additionalThrust;
        this.weight = weight;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public int getAdditionalThrust(){
        return additionalThrust;
    }
    
    @Override
    public String toString(){
        return getName() 
        + "\nSpecs: " 
        + "\n   Additional Thrust: " + additionalThrust + "kN"
        + "\n   Weight: " + weight
        + "\n Price: " + price;  
    }
}
