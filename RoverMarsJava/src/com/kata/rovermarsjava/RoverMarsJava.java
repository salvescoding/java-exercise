package com.kata.rovermarsjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RoverMarsJava {

    private static List<String> instructions = new ArrayList<String>();
    private static Map map;
    private static Coordinates coordinates;
    private static Rover rover;
    private static List<String> roversLandingPosition = new ArrayList<String>();
    private static List<String> roversCommands = new ArrayList<String>();
    private static List<Rover> rovers = new ArrayList<Rover>();



    public static void main(String[] args) {
        openFile();
        setMap();
        getRoversInitialLocation();
        landRovers();
    }



    private static void openFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("src/input.txt")));
            saveInputinArray(reader);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void saveInputinArray(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            instructions.add(line);
        }
    }

    private static void setMap() {
        String values = instructions.get(0);
        String[] mapValues = values.split(" ");
        int x =  Integer.parseInt(mapValues[0]);
        int y =  Integer.parseInt(mapValues[1]);
        map = new Map(x, y);
    }

    private static void getRoversInitialLocation() {
        for (int i = 0; i < instructions.size(); i++) {
            if (i % 2 != 0) {
                roversLandingPosition.add(instructions.get(i));
            }
            else if ((i != 0) && (i % 2 == 0)) {
                roversCommands.add(instructions.get(i));
            }
        }
    }

    private static void landRovers() {
        for (String roverLanding : roversLandingPosition) {
            String[] roverPosition = roverLanding.split(" ");
            int x = Integer.parseInt(roverPosition[0]);
            int y = Integer.parseInt(roverPosition[1]);
            char d = roverLanding.charAt(4);
            coordinates = new Coordinates(x, y, d, map);
            rover = new Rover(coordinates);
            rovers.add(rover);
        }
    }

}
