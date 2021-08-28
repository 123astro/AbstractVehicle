package com.company;

public class Plane extends Vehicle {
    private boolean isLandbased;
    private boolean isAmphibious;
    private int lbsCapacity;


    public Plane(String operatorName, String colorOfVehicle, int numberOfSeats, Engine engine, Passenger passenger,
                 boolean islandBased, boolean amphibious, int lbsCapacity) {
        super(operatorName, colorOfVehicle, numberOfSeats, engine, passenger);
        this.isLandbased = islandBased;
        this.isAmphibious = amphibious;
        this.lbsCapacity = lbsCapacity;
    }

    @Override
    public void horn(){
        System.out.println("ear shattering noise");
    }

    @Override
    public void motorSound(){
        System.out.println("buzzzzzzzzzzzzzzzzzzzzz");
    };

}
