package com.company.vehicle;

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
            "3. Coast",
            "4. Turn ignition on",
            "5. Exit Program - Vehicle on fire!!!"
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
        displayOptions("Your choices:", CAR_SELECTION);
        int choice = getInt(1, 2, "Please selected a car.");
        choseCarFromLot(choice);
        displayOptions("Engines: ", ENGINE);
        choice = getInt(1, 2, "Please select an engine");
        selectEngine(choice);

    }

    public void startVehicle() {
        vehicle.startVehicle();
    }

    public void stopVehicle() {
        vehicle.stopVehicle();
    }

    public boolean start() {
        vehicle.displayEngine();
        displayOptions("Your choices:", DRIVE);
        int choice = getInt(1, 5, "Please select an acton:");
        return handleMenuSelection(choice);
    }

    public boolean handleMenuSelection(int choice) {
        switch (choice) {
            case 1 -> this.accelerate();
            case 2 -> this.decelerate();
            case 3 -> this.coast();
            case 4 -> this.startVehicle();
            case 5 -> {
                System.out.println("******************BOOM*****************");
                return false;
            }
            default -> System.out.println("Invalid");
        }

        return checkPositionOnTrack();
    }

    public boolean isVehicleOn() {
        return vehicle.getEngine().isOn();
    }

    public void choseCarFromLot(int choice) {
        switch (choice) {
            case 1 -> {
                vehicle = new Car("You", "Black", 2, "BUG", "VOLKSWAGEN", 2);
                System.out.println("THE OPERATOR AND CAR: " + vehicle);
            }
            case 2 -> {
                vehicle = new Car("You", "Black", 2, "Chevy", "Corvette", 2);
                System.out.println("THE OPERATOR AND CAR: " + vehicle);
            }
            default -> System.out.println(" Please select a vehicle.");
        }
    }

    public void selectEngine(int choice) {
        switch (choice) {
            case 1 -> {
                vehicle.addEngine(new V6(true));
            }
            case 2 -> {
                vehicle.addEngine(new V8(true));
            }
            default -> System.out.println(" Please select an engine.");
        }
    }

    public void accelerate() {
        if (isVehicleOn()) {
            speed += 10;
            rawSpeed += 1;
            windResistance();
            distanceLeft -= calculatedWindDistance;
            System.out.println("Current distance left to travel " + getDistanceLeft() + " meters");
            System.out.println("Current speed " + getSpeed() + " mph.");

        } else {
            System.out.println("************Please start vehicle*******************");
        }
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
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void decelerate() {
        if (isVehicleOn()) {
            speed -= 10;
            if (getSpeed() < 0) {
                setSpeed(0);
                System.out.println("**************** Vehicle has come to a halt! Please " +
                        "accelerate!! **********************");
                return;
            }
            rawSpeed -= 1;
            windResistance();
            distanceLeft -= calculatedWindDistance;
            System.out.println("Current distance left to travel: " + getDistanceLeft() + " meters");
            System.out.println("Current speed " + getSpeed());
            if (getSpeed() == 0)
                System.out.println("Current speed " + getSpeed());
            if (getSpeed() == 0) {
                System.out.println("Vehicle has drifted to a stopped!! ");
                distanceLeft -= 1;
                System.out.println("Current distance left to travel " + getDistanceLeft() + " meters");
            }
        } else {
            System.out.println("The engine is not even on!!! Please start and then accelerate in order to decelerate" +
                    " you big dummy !!");
        }
    }

    public void stop() {
        System.exit(1);
    }

    public int windResistance() {
        int min = 1;
        int max = 10;
        int incrementedPower = 10;
        if (vehicle.getEngine().getHorsepower() == 400) {
            incrementedPower = 12;
        }
        int wind = (int) Math.round(Math.random() * (max - min + 1) + min);
        windSpeed = wind * 10;
        calculatedWindDistance = (incrementedPower - wind) + (1 + rawSpeed);
        System.out.println("The vehicle has gone " + calculatedWindDistance + " meters.");
        System.out.println("Head wind was: " + windSpeed + " mph.");
        return wind;
    }

    public boolean checkPositionOnTrack() {
        if (distanceLeft <= -11) {
            System.out.println(" ********************You hit the wall of doom - you loser !!!! " +
                    "***************************");
            return false;
        }
        if (distanceLeft < 0 && distanceLeft > -10) {
            System.out.println("*******************You win!!****************************");
            return false;
        } return true;
    }
}

