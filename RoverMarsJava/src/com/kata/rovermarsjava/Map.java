package com.kata.rovermarsjava;

public class Map {

    private int x;
    private int y;

    public int getX() { return x; }

    public int getY() { return y; }

    private void setX(int x) { this.x = x; }

    private void setY(int y) { this.y = y; }

    public Map(int x, int y) {
        setX(x);
        setY(y);
    }
}
