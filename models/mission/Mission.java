package models.mission;

public abstract class Mission {

    protected String name;
    protected boolean hasToBeManned;
    protected long distance;
    protected String duration;
    protected double fuelCoefficient;

    public Mission(String name, boolean hasToBeManned, long distance, String duration, double fuelCoefficient){
        this.name = name;
        this.hasToBeManned = hasToBeManned;
        this.distance = distance;
        this.duration = duration;
        this.fuelCoefficient = fuelCoefficient;
    }
}
