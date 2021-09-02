package com.company.engine;

public class V8 extends Engine {

    public V8(boolean isUnleaded) {
        super(isUnleaded);
        horsepower = 400;
        numberOfCylinders = 8;
    }


    @Override
    public String toString() {
        return super.toString() + " | Number of Cylinders: " + numberOfCylinders + " | HorsePower: " + horsepower;
    }
}
