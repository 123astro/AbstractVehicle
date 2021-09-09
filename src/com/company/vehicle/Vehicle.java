package com.company.vehicle;

import com.company.Passenger;
import com.company.console.Controls;
import com.company.engine.Engine;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Vehicle {
    private String operatorName;
    private String colorOfVehicle;
    private int numberOfSeats;
    private Engine engine;
    private List<Passenger> passengers = new ArrayList<>();
    public Controls controls = new Controls();

    public Vehicle(String operatorName, String colorOfVehicle, int numberOfSeats) {
        this.operatorName = operatorName;
        this.colorOfVehicle = colorOfVehicle;
        this.numberOfSeats = numberOfSeats;

    }

    public Engine getEngine() {
        return engine;
    }

    public void startVehicle() {
        engine.startEngine();
    }

    public void stopVehicle() {
        engine.stopEngine();
    }

    @Override
    public String toString() {
        String output = "Name of operator: " + operatorName + " | Vehicle color: " + colorOfVehicle +
                " | Number of seats: " + numberOfSeats;
        return output;
    }

    public void displayEngine() {
        System.out.println(toString() + engine);
    }

    public void addEngine(Engine engine){
        this.engine = engine;
    }

    public abstract void horn();

    public abstract void motorSound();

    public void displayAllPassengers() {
        System.out.println(passengers);
    }

    public void addPassenger(String passengerName) {
        passengers.add( new Passenger(passengerName));
    }

    public void removePassenger(String passenger){
        for(int i = 0; i < passengers.size(); i++){
            if(Objects.equals(passenger, passengers.get(i).getPassengerName())) {
                passengers.remove(i);
                break;
            }
        }
    }
}


