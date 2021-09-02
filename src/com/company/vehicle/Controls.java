package com.company.vehicle;


import com.company.engine.Engine;
import com.company.engine.V6;
import com.company.engine.V8;

import java.util.Scanner;

public class Controls {
    private Vehicle vehicle;
    private int speed = 0;
    private int rawSpeed = 0;
    private int incrementDistance = 0;
    private int distanceLeft = 100;
    private int windSpeed = 0;
    private int calculatedWindDistance = 0;


    public static Scanner scanner = new Scanner(System.in);

    private final static String[] CAR_SELECTION = new String[]{
            "1. 1969 VW BUG",
            "2. 1968 Corvette split back"
    };

    private final static String[] ENGINE = new String[]{
            "1. V6 230 HP",
            "2. V8 400 HP"
    };

    private final static String[] DRIVE = new String[]{
            "1. Accelerate",
            "2. Decelerate",
            "3. Coast"
    };

    public static void displayOptions(String prompt, String[] options) { // prompt is the first line to print ( to do)
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static int getInt(int min, int max, String prompt) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Input numbers only!");
            }
        } while (option < min || option > max);
        return option;
    }

    public void getSelections() {
        displayOptions("Your choices", CAR_SELECTION);
        int choice = getInt(1, 2, "Please selected a car");
        carLot(choice);
        displayOptions("Engines: ", ENGINE);
        choice = getInt(1, 2, "Please select an engine.");
        selectEngine(choice);
    }

    public boolean start() {
        vehicle.startVehicle();
        System.out.println("Vehicle is running.");
        displayOptions("Your choices:", DRIVE);
        int choice = getInt(1, 3, "Select an acton:");
        return handleMenuSelection(choice);
    }

    public boolean handleMenuSelection(int choice) {
        switch (choice) {
            case 1 -> this.accelerate();
            case 2 -> this.decelerate();
            case 3 -> this.coast();
            case 4 -> {
                return false;
            }
            default -> System.out.println("Invalid");
        }
        return true;
    }

    public void carLot(int choice) {
        switch (choice) {
            case 1 -> {
                vehicle = new Car("You", "black", 2, "bug", "vw", 2);
                System.out.println(vehicle);
            }
            case 2 -> {
                vehicle = new Car("You", "black", 2, "Chevy", "Corvette", 2);
                System.out.println(vehicle);
            }
            default -> System.out.println(" Please select a vehicle.");
        }
    }

    public void selectEngine(int choice) {
        switch (choice) {
            case 1 -> {
                vehicle.addEngine(new V6(true));
                vehicle.displayEngine();
            }
            case 2 -> {
                vehicle.addEngine(new V8(true));
                vehicle.displayEngine();
            }
            default -> System.out.println(" Please select an engine.");
        }
    }

    public void accelerate() {
        speed += 10;
        rawSpeed += 1;
        windResistance();
        distanceLeft -= calculatedWindDistance;
        System.out.println("Current distance left to travel " + getDistanceLeft() + " meters");
        System.out.println("Current speed " + getSpeed());
        checkPositionOnTrack();
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceLeft() {
        return distanceLeft;
    }

    public void coast() {
        windResistance();
        System.out.println("Current speed " + getSpeed());
        if (getSpeed() == 0) {
            System.out.println("Vehicle has drifted to a stopped!! ");
            distanceLeft -= 1;
            System.out.println("Current distance left to travel " + getDistanceLeft() + " meters");
            return;
        }
        distanceLeft -= calculatedWindDistance;
        System.out.println("Current distance left to travel: " + getDistanceLeft() + " meters");
        speed -= 2;
        checkPositionOnTrack();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void decelerate() {
        speed -= 10;
        if (getSpeed() < 0) {
            setSpeed(0);
            System.out.println("****************Vehicle has come to a halt! Please accelerate!!**********************");
            return;
        }
        rawSpeed -= 1;
        windResistance();
        distanceLeft -= calculatedWindDistance;
        System.out.println("Current distance left to travel: " + getDistanceLeft() + " meters");
        System.out.println("Current speed " + getSpeed());
        if (getSpeed() == 0)
            System.out.println("Current speed " + getSpeed());
        checkPositionOnTrack();
        if (getSpeed() == 0) {
            System.out.println("Vehicle has drifted to a stopped!! ");
            distanceLeft -= 1;
            System.out.println("Current distance left to travel " + getDistanceLeft() + " meters");
            //getSelections();
        }

    }

    public void stop() {
        System.exit(1);
    }

    public int windResistance() {
        int min = 1;
        int max = 10;
        int wind = (int) Math.round(Math.random() * (max - min + 1) + min);
        windSpeed = wind * 10;
        calculatedWindDistance = (10 - wind) + (1 + rawSpeed);
        System.out.println("The vehicle has gone " + calculatedWindDistance + " meters.");
        System.out.println("Head wind was: " + windSpeed + " mph.");
        return wind;
    }

    public void checkPositionOnTrack() {
        if (distanceLeft <= -11) {
            System.out.println(" ********************You hit the wall of doom - you loser !!!! " +
                    "***************************");
            stop();
        }
    }
}

