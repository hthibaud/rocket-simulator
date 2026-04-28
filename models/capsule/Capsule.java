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

    public int getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public boolean getIsManned(){
        return isManned;
    }

    @Override
    public String toString(){
        return "Your capsule's name: " + getName();
    }
}
