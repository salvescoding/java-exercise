package com.kata.rovermarsjava;

public class Point {

    private int roverPoint;
    private int mapMax;

    public int getRoverPoint() { return roverPoint; }

    public void setRoverPoint(int roverPoint) {
        this.roverPoint = roverPoint;
    }

    public int getMapMax() { return mapMax; }

    public void setMapMax(int mapMax) {
        this.mapMax = mapMax;
    }

    public Point(int roverPoint, int mapMax) {
        setRoverPoint(roverPoint);
        setMapMax(mapMax);
    }
}
