package com.kata.rovermarsjava;

import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public Map initMap(String[] mapValues) {
       return new Map(Integer.parseInt(mapValues[0]), Integer.parseInt(mapValues[1]));
    }

    public List<Rover> initRovers(List<String> roversInitialPosition, Map map) {
        List<Rover> rovers = new ArrayList<>();
        for (String roverInitial : roversInitialPosition) {
            String[] roverPosition = roverInitial.split(" ");
            char d = roverInitial.charAt(4);
            Rover rover = new Rover(
                    Integer.parseInt(roverPosition[0]),
                    Integer.parseInt(roverPosition[1]),
                    roverInitial.charAt(4),
                    map
            );
            rovers.add(rover);
        }
        return rovers;
    }
}
