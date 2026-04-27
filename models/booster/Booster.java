package models.booster;

public class Booster {
    
    protected String name;
    protected int additionalThrust;
    protected double weight;
    protected int price;

    public Booster(String name, int additionalThrust, double weight, int price){
        this.name = name;
        this.additionalThrust = additionalThrust;
        this.weight = weight;
        this.price = price;
    }
}
