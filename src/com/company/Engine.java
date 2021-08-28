package com.company;

public class Engine {
    private int horsePower;
    private int numberOfMotors;
    private boolean isGasMotor;
    protected boolean isOn;

    public Engine(int horsePower, int numberOfMotors, boolean isGasMotor){
        this.horsePower = horsePower;
        this.numberOfMotors = numberOfMotors;
        this.isGasMotor = isGasMotor;
        isOn = false;
    }

    public String toString() {
        return   " | Horse Power : " + horsePower + " | Number of motors:  " +  numberOfMotors + " |" +
                " Is a gas motor: " + isGasMotor + " |  Is motor on: " + isOn;
    }


}
