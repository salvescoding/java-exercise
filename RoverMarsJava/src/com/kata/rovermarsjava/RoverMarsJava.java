package com.kata.rovermarsjava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class RoverMarsJava {

    private static final List<String> instructions = new ArrayList<>();
    private static Map map;
    private static final List<String> roversLandingPosition = new ArrayList<>();
    private static final List<String> roversCommands = new ArrayList<>();
    private static final List<Rover> rovers = new ArrayList<>();



    public static void main(String[] args) {
        openFile();
        String[] mapValues = getMap();
        setMap(mapValues);
        getRoversInitialPosition();
        getRoversCommands();
        landRovers();
        moveRovers();
        OutputFinalPosition();
    }


    private static void openFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File("src/input.txt")));
            saveFileInputInInstructions(reader);
        }
        catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    private static void saveFileInputInInstructions(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            instructions.add(line);
        }
    }

    private static String[] getMap() {
        return instructions.get(0).split(" ");

    }

    private static void setMap(String[] mapValues) {
        map = new Map(Integer.parseInt(mapValues[0]), Integer.parseInt(mapValues[1]));
    }

    private static void getRoversInitialPosition() {
        for (int i = 0; i < instructions.size(); i++) {
            if (i % 2 != 0) {
                roversLandingPosition.add(instructions.get(i));
            }
        }
    }


    private static void getRoversCommands() {
        for (int i = 0; i < instructions.size(); i++) {
            if ((i != 0) && (i % 2 == 0)) {
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
            Coordinates coordinates = new Coordinates(x, y, d, map);
            Rover rover = new Rover(coordinates);
            rovers.add(rover);
        }
    }

    private static void moveRovers() {
        for (int i = 0; i < roversCommands.size(); i++) {
            rovers.get(i).receiveCommands(roversCommands.get(i));
        }
    }

    private static void OutputFinalPosition() {
        for (Rover rover : rovers) {
            System.out.println(rover.getPosition());
        }
    }
}
