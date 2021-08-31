package com.company;


import com.company.engine.V6;
import com.company.vehicle.Car;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Jon", "Red", 4, "f150", "ford",  2);
        System.out.println(car1);
        V6 engine = new V6(true);
        car1.addEngine(engine);
        car1.displayEngine();
        car1.startVehicle();
        car1.displayEngine();

//        System.out.println(car1);1
//        car1.displayEngine();
//        car1.displayPassengers();
//        car1.horn();
//        car1.motorSound();
//        car1.stopVehicle();
//        System.out.println(car1);
        car1.addPassenger("Ken");
//        car1.addPassenger("Max");
        car1.displayAllPassengers();
        car1.removePassenger("Ken");
        car1.displayAllPassengers();
        boolean isRunning = true;
//        Boat boat1 = new Boat("Pete", "brown",3, new Engine(200, 1, true), new Passenger("Derek"), false, true);
//        System.out.println(boat1);
//        boat1.displayEngine();
//        boat1.addPassenger("Paul");
//        boat1.displayPassengers();
//        car1.accelerate();
//;
        do {
            car1.controls.getSelections();

        } while (isRunning);
    }
}