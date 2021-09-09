package com.company.console;

import com.company.vehicle.Car;
import com.company.vehicle.Vehicle;

import java.util.List;

public class NewCars implements CarYears {
    @Override
    public String[] CAR_SELECTION() {
        return new String[]{
                "1. 2020 VW BUG",
                "2. 2021 Corvette"
        };
    }

    @Override
    public List<Vehicle> CARS() {

        return List.of(
                new Car("You", "Black", 2, "BUG", "2020 VOLKSWAGEN", 2),
                new Car("You", "Black", 2, "Chevy", "2021 Corvette", 2)
        );
    }
}