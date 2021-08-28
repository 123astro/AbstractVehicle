package com.company;


public class Car extends Vehicle {
    private String type;
    private String brand;
    private int numberOfDoors;



    public Car(String operatorName, String colorOfVehicle, int numberOfSeats, Engine engine, Passenger passenger,
               String type, String brand, int numberOfDoors) {
        super(operatorName, colorOfVehicle, numberOfSeats, engine, passenger);
        this.type = type;
        this.brand = brand;
        this.numberOfDoors = numberOfDoors;
    }


    public String toString() {
        return super.toString() + " | Type of car: " + type + " | Brand of car: " + brand + " | Numbers of doors: " +  +
                numberOfDoors ;
    }
    @Override
    public void horn(){
        System.out.println("beep beep");
    }

    @Override
    public void motorSound(){
        System.out.println("voom voom");
    };

}


