package com.company.engine;

public class V8 extends Engine {
    private int numberOfCylinders = 8;
    private int horsepower = 450;


    public V8( boolean isGas) {
        super(isGas);
    }


    @Override
    public String toString() {
        return super.toString() + " | Number of Cylinders: " + numberOfCylinders + " | HorsePower: " + horsepower;
    }
}
