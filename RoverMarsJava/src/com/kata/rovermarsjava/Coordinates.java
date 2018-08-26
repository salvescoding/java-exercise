package com.kata.rovermarsjava;

public class Coordinates {

    private int x;
    private int y;
    private char direction;
    private Map map;
    private char[] compass = new char[]{'N', 'E', 'S', 'W'};


    public int getX() { return x; }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() { return y; }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() { return direction; }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Map getMap() { return map; }

    public void setMap(Map map) {
        this.map = map;
    }

    public Coordinates(int x, int y, char direction, Map map) {
        setX(x);
        setY(y);
        setDirection(direction);
        setMap(map);
    }




}
