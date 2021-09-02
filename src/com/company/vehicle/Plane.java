package com.company.vehicle;

public class Plane extends Vehicle {
    private boolean isLandbased;
    private boolean isAmphibious;
    private int lbsCapacity;


    public Plane(String operatorName, String colorOfVehicle, int numberOfSeats,
                 boolean islandBased, boolean amphibious, int lbsCapacity) {
        super(operatorName, colorOfVehicle, numberOfSeats);
        this.isLandbased = islandBased;
        this.isAmphibious = amphibious;
        this.lbsCapacity = lbsCapacity;
    }

    @Override
    public void horn() {
        System.out.println("High freq beep");
    }

    @Override
    public void motorSound() {
        System.out.println("buzzzzzzzzzzzzzzzzzzzzz");
    }

    ;

}
