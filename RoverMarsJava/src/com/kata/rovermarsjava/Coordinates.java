package com.kata.rovermarsjava;

import java.util.*;

public class Coordinates {

    private int x;
    private int y;
    private char direction;
    private Map map;
    private static char[] compass = new char[]{'N', 'E', 'S', 'W'};

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

    public void move(char orientation) {
        switch (orientation) {
            case 'N': setX(getX() + 1);
                      break;
            case 'E': setY(getY() + 1);
                      break;
            case 'S': setX(getX() - 1);
                      break;
            case 'W': setY(getY() - 1);
                      break;
        }
    }

    public void turnRight() {
        int indexOrientation = getIndexOfCompass();
        if (indexOrientation == (compass.length - 1)) {
            setDirection('N');
        }
        else {
            int newIndex = indexOrientation + 1;
            char newOrient = compass[newIndex];
            setDirection(newOrient);
        }
    }

    private int getIndexOfCompass() {
        int index = 0;
        for (int i = 0; i < compass.length; i++) {
            if (getDirection() == compass[i]) {
                index = i;
            }
        }
        return index;
    }


}
