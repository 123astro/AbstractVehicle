package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passenger {

    private List<String> passengers = new ArrayList<String>();

    public Passenger(String passengerName) {
        passengers.add((passengerName));
    }

    public void displayAllPassengers() {
        System.out.println(passengers);
    }

    public void addPassenger(String passengerName) {
        passengers.add(passengerName);
    }

    public void removePassenger(String passenger){
       for(int i = 0; i < passengers.size(); i++){
           if(Objects.equals(passenger, passengers.get(i))) {
               passengers.remove(i);
           }
       }
    }
}
