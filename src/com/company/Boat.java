package com.company;


public class Boat extends Vehicle {

    private boolean isSailboat;
    private boolean isMotorBoat;


    public Boat(String operatorName, String colorOfVehicle, int numberOfSeats, Engine engine, Passenger passenger,
                boolean isSailboat, boolean motorBoat) {
        super(operatorName, colorOfVehicle, numberOfSeats, engine, passenger);
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
