package com.company.vehicle;


import java.util.Scanner;

public class Controls {
    private int speed = 0;
    private int rawSpeed = 0;
    private int incrementDistance = 0;
    private int distanceLeft = 100;
    private int windSpeed = 0;
    private int calculatedWindDistance = 0;

    public static Scanner scanner = new Scanner(System.in);

    public void getSelections() {

        System.out.println("\nWould you like to:" +
                "\nAcelerate ?           1" +
                "\nDecelerate ?          2" +
                "\nCoast ?               3" +
                "\nThe object is to get as close to the finish line as possible. 0 distance represents the finish " +
                "line. You can not do more than 10 meters past the line because you will die and hit a wall.");
        valid();
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1 -> this.accelerate();
            case 2 -> this.decelerate();
            case 3 -> this.coast();
            case 4 -> this.stop();
            default -> getSelections();
        }
    }

    public void valid() {
        while (!scanner.hasNextInt()) {
            System.out.println("Input needs to be one of the numbers above.");
            scanner.nextLine();
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
            getSelections();
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
        if (distanceLeft <= -11){
            System.out.println(" ********************You hit the wall of doom - you loser !!!! " +
                    "***************************");
            stop();
        }
    }
}

