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
    @Override
    public String toString(){
        return "Launcher's name: " + getName();
    }
}