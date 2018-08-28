package com.kata.rovermarsjava;

public class Rover {

    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Rover(Coordinates coordinates) {
        setCoordinates(coordinates);
    }

    public void receiveCommands(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            runCommand(command);
        }
    }

    public String getPosition() {
        String position = getCoordinates().toString();
        return position;
    }

    private void runCommand(char command) {
        switch (command) {
            case 'M':
                coordinates.move(coordinates.getDirection());
                break;
            case 'L':
                coordinates.turnLeft();
                break;
            case 'R':
                coordinates.turnRight();
                break;
        }
    }


}
