package com.kata.rovermarsjava;

class Rover {

    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }
    private void setCoordinates(Coordinates coordinates) {
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
        return getCoordinates().toString();
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
