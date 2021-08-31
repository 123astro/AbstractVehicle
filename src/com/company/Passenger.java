package com.company;

public class Passenger {
    private String passengerName;

    public Passenger(String passengerName) {
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                '}';
    }

    public String getPassengerName() {
        return passengerName;
    }
}
