package com.company.engine;

public abstract class Engine {
    private final boolean isUnleaded;
    private boolean isOn = false;
    protected int horsepower;
    protected int numberOfCylinders;


    public Engine(boolean isUnleaded) {
        this.isUnleaded = isUnleaded;
    }

    public void startEngine() {
        isOn = true;
    }

    public void stopEngine() {
        isOn = false;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public boolean isOn() {
        return isOn;
    }

    public String toString() {
        return "| Gas fuel: " + isUnleaded + " | Is on: " + isOn;
    }


}
