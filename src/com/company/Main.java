package com.company;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Jon", "Red", 4, new Engine(300, 1, true), new Passenger("Steven"),"Ford", "F150",2);
        System.out.println(car1);
        car1.startVehicle();
        System.out.println(car1);
        car1.displayEngine();
        //car1.displayPassengers();
        car1.horn();
        car1.motorSound();
        car1.stopVehicle();
        System.out.println(car1);
        car1.addPassenger("Ken");
        car1.addPassenger("Max");
        car1.displayPassengers();
        car1.removePassenger("Max");
        car1.displayPassengers();
        Boat boat1 = new Boat("Pete", "brown",3, new Engine(200, 1, true), new Passenger("Derek"), false, true);
        System.out.println(boat1);
        boat1.displayEngine();
        boat1.addPassenger("Paul");
        boat1.displayPassengers();





    }

}