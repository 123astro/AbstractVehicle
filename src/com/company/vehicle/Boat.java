package com.company.vehicle;


public class Boat extends Vehicle {

    private boolean isSailboat;
    private boolean isMotorBoat;


    public Boat(String operatorName, String colorOfVehicle, int numberOfSeats,
                boolean isSailboat, boolean motorBoat) {
        super(operatorName, colorOfVehicle, numberOfSeats);
        this.isSailboat = isSailboat;
        this.isMotorBoat = motorBoat;
    }

    @Override
    public void horn() {
        System.out.println("quack quack");
    }

    @Override
    public void motorSound() {
        System.out.println("brrr brrr");
    }

    ;
}
