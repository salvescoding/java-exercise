package com.kata.rovermarsjava;

import java.util.ArrayList;
import java.util.List;


class RoverMarsJava {

    private static List<Rover> rovers = new ArrayList<>();
    private static List<String> roversCommands = new ArrayList<>();

    public static void main(String[] args) {
        FileParser fileParser = new FileParser("src/input.txt");
        List<String> fileInstructions = fileParser.extractInputFromFile();
        Interpreter interpeter = new Interpreter(fileInstructions);
        String[] mapValues = interpeter.getMap();
        List<String> roversInitialPosition = interpeter.getRoversInitialPosition();
        roversCommands = interpeter.getRoversCommands();
        Initializer initializer = new Initializer();
        Map map = initializer.initMap(mapValues);
        rovers = initializer.initRovers(roversInitialPosition, map);
        moveRovers();
        OutputFinalPosition();
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
