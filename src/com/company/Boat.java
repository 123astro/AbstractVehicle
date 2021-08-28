package com.company;


public class Boat extends Vehicle {

    private boolean isSailboat;
    private boolean isMotorBoat;


    public Boat(String operatorName, String colorOfVehicle, int numberOfSeats, Engine engine, Passenger passenger,
                boolean sailBoat, boolean motorBoat) {
        super(operatorName, colorOfVehicle, numberOfSeats, engine, passenger);
        this.isSailboat = sailBoat;
        this.isMotorBoat = motorBoat;

    }

    @Override
    public void horn() {
        System.out.println("fog horn sound");
    }

    @Override
    public void motorSound() {
        System.out.println("brrr brrr");
    }

    ;
}
