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

}
