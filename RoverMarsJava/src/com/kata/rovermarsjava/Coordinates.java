package com.kata.rovermarsjava;

public class Coordinates {

    private int x;
    private int y;
    private char direction;
    private Map map;
    private static final char[] compass = new char[]{'N', 'E', 'S', 'W'};

    public int getX() { return x; }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() { return y; }

    private void setY(int y) {
        this.y = y;
    }

    public char getDirection() { return direction; }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Map getMap() { return map; }

    private void setMap(Map map) {
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
            case 'N': setY(getY() + 1);
                      break;
            case 'E': setX(getX() + 1);
                      break;
            case 'S': setY(getY() - 1);
                      break;
            case 'W': setX(getX() - 1);
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
            char newOrientation = compass[newIndex];
            setDirection(newOrientation);
        }
    }

    public void turnLeft() {
        int indexOrientation = getIndexOfCompass();
        if (indexOrientation == 0) {
            setDirection('W');
        }
        else {
            int newIndex = indexOrientation - 1;
            char newOrientation = compass[newIndex];
            setDirection(newOrientation);
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

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getDirection();
    }


}
