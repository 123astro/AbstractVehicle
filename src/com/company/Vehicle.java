package com.company;

public abstract class Vehicle {
    private String operatorName;
    private String colorOfVehicle;
    private int numberOfSeats;
    private Engine engine;
    private Passenger passenger;
    public DriversSeat driversSeat = new DriversSeat();

    public Vehicle(String operatorName, String colorOfVehicle, int numberOfSeats, Engine engine, Passenger passenger) {
        this.operatorName = operatorName;
        this.colorOfVehicle = colorOfVehicle;
        this.numberOfSeats = numberOfSeats;
        this.engine = engine;
        this.passenger = passenger;
    }

    public void startVehicle() {
        engine.isOn = true;
    }

    public void stopVehicle() {
        engine.isOn = false;
    }

    @Override
    public String toString() {
        String output = "Name of passenger: " + operatorName + " | Vehicle color: " + colorOfVehicle +
                " | Number of seats: " + numberOfSeats +
                " | Is engine on: " + engine.isOn;
        return output;
    }

    public void displayEngine() {
        System.out.println(toString() + engine);
    }

    public void displayPassengers() {
        displayEngine();
        passenger.displayAllPassengers();
    }

    public void addPassenger(String passengerName) {
        passenger.addPassenger(passengerName);
    }

    public void removePassenger(String passengerName) {
        passenger.removePassenger(passengerName);
    }

    public abstract void horn();

    public abstract void motorSound();


}


