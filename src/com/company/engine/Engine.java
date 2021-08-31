package com.company.engine;

public abstract class Engine {
    private boolean isGas = false ;
    private boolean isOn = false;

    public Engine(boolean isGas) {
        this.isGas = isGas;
    }

    public void startEngine(){
        isOn = true;
    }

    public void stopEngine(){
        isOn = false;
    }
    public String toString() {
        return " | Gas fuel: " + isGas + " | Is on: " + isOn;
    }


}
