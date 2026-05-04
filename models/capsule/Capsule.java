package models.capsule;

public abstract class Capsule {

    protected String name;
    protected boolean isManned;
    protected int maxPeople;
    protected int price;
    protected double weight;

    public Capsule(String name, boolean isManned, int maxPeople, int price, double weight) {
        this.name = name;
        this.isManned = isManned;
        this.maxPeople = maxPeople;
        this.price = price;
        this.weight = weight;
    }

    //returns the price of the capsule
    public int getPrice() {
        return price;
    }

    //returns the name of the capsule
    public String getName(){
        return name;
    }

    //returns the weight of the capsule
    public double getWeight(){
        return weight;
    }

    //returns if the capsule is manned
    public boolean getIsManned(){
        return isManned;
    }

    //toString method for the capsule
    @Override
    public String toString(){
        String isManned2;

        if (isManned == true){
            isManned2 = "yes";
        } else {
            isManned2 = "no";
        }
        return getName() 
        + "\nSpecs: " 
        + "\n   Is manned: " + isManned2 + ", " +  maxPeople + " people max"
        + "\n   Weight: " + weight + " tons"
        + "\n   Price: " + price + "Millions€";  
    }
}
