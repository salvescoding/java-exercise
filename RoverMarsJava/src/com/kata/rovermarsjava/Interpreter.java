package com.kata.rovermarsjava;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    private List<String> fileInstructions;

    public Interpreter(List<String> fileInstructions) {
        this.fileInstructions = fileInstructions;
    }

    public List<String> getRoversInitialPosition() {
        List<String> roversLandingPosition = new ArrayList<>();
        for (int i = 0; i < fileInstructions.size(); i++) {
            if (i % 2 != 0) {
                roversLandingPosition.add(fileInstructions.get(i));
            }
        }
        return roversLandingPosition;
    }

    public String[] getMap() {
        return fileInstructions.get(0).split(" ");
    }

    public List<String> getRoversCommands() {
        List<String> roversCommands = new ArrayList<>();
        for (int i = 0; i < fileInstructions.size(); i++) {
            if ((i != 0) && (i % 2 == 0)) {
                roversCommands.add(fileInstructions.get(i));
            }
        }
        return roversCommands;
    }
}
