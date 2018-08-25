package com.kata.rovermarsjava;

public class Rover {

    private int x;
    private int y;
    private String orientation;

    public int getX() { return x; }

    public int getY() { return y; }

    public String getOrientation() { return orientation; }

    public Rover(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
}
