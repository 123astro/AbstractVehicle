package com.company.engine;

public class V6 extends Engine {

    public V6(boolean isUnleaded) {
        super(isUnleaded);
        horsepower = 230;
        numberOfCylinders = 6;
    }

    @Override
    public String toString() {
        return super.toString() + " | Number of Cylinders: " + numberOfCylinders + " | HorsePower: " + horsepower ;
    }
}
