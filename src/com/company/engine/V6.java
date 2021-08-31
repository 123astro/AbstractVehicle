package com.company.engine;

public class V6 extends Engine {
    private int numberOfCylinders = 6;
    private int horsepower = 230;


    public V6(boolean isGas) {
        super(isGas);
    }

    @Override
    public String toString() {
        return super.toString() + " | Number of Cylinders: " + numberOfCylinders + " | HorsePower: " + horsepower ;
    }
}
