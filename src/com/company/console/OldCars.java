package com.company.console;

import com.company.vehicle.Car;
import com.company.vehicle.Vehicle;

import java.util.List;

public class OldCars implements CarYears {
    @Override
    public String[] CAR_SELECTION() {
        return new String[]{
                "1. 1968 VW BUG",
                "2. 1962 Corvette split back"
        };
    }

    @Override
    public List<Vehicle> CARS() {
        return List.of(
                new Car("You", "Black", 2, "BUG", "1968 VOLKSWAGEN", 2),
                new Car("You", "Black", 2, "Chevy", "1962 CORVETTE split back", 2)
        );
    }
}