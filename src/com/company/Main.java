package com.company;

import com.company.vehicle.Controls;

public class Main {

    public static void main(String[] args) {
     Controls controls = new Controls();
     controls.getSelections();
     while (controls.start());
    }
}