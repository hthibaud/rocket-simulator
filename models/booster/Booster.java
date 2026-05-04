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

    //returns the price of the booster
    public int getPrice() {
        return price;
    }

    //returns the name of the booster
    public String getName(){
        return name;
    }

    //returns the weight of the booster
    public double getWeight(){
        return weight;
    }

    //returns the additionnal thrust of the booster
    public int getAdditionalThrust(){
        return additionalThrust;
    }
    
    //toString method for the booster
    @Override
    public String toString(){
        return getName() 
        + "\nSpecs: " 
        + "\n   Additional Thrust: " + additionalThrust + "kN"
        + "\n   Weight: " + weight + " tons"
        + "\n   Price: " + price + "Millions€";  
    }
}
