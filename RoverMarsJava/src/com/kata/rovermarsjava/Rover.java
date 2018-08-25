package com.kata.rovermarsjava;

public class Rover {

    private int x;
    private int y;
    private char orientation;

    public int getX() { return x; }

    public int getY() { return y; }

    public char getOrientation() { return orientation; }

    public String getRoverPosition() {
        String position = getPositionToString();
        return position;
    }

    public Rover(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    private String getPositionToString() {
        String x = Integer.toString(getX());
        String y = Integer.toString(getY());
        String o = String.valueOf(getOrientation());
        return "X: " + x + ", Y: " + y + ", Orientation: " + o;
    }
}
