package com.kata.rovermarsjava;

import java.io.PipedInputStream;

public class Coordinates {


    private static final char[] compass = new char[]{'N', 'E', 'S', 'W'};
    private char direction;
    private Point x;
    private Point y;

    public int getRoverXPoint() { return x.getRoverPoint(); }

    private void setX(Point x) {
        this.x = x;
    }

    public int getMapX() { return x.getMapMax(); }

    private void setRoverXPoint(int x) {
        this.x.setRoverPoint(x);
    }

    public int getRoverYPoint() { return y.getRoverPoint(); }

    private void setRoverYPoint(int y) {
        this.y.setRoverPoint(y);
    }

    public int getMapY() {
        return y.getMapMax();
    }

    private void setY(Point y) {
        this.y = y;
    }

    public char getDirection() { return direction; }

    public void setDirection(char direction) {
        this.direction = direction;
    }


    public Coordinates(Point x, Point y, char direction) {
        setX(x);
        setY(y);
        setDirection(direction);
    }

    public void move(char orientation) {
        switch (orientation) {
            case 'N': moveNorth();
                      break;
            case 'E': moveEast();
                      break;
            case 'S': moveSouth();
                      break;
            case 'W': moveWest();
                      break;
        }
    }

    private void moveWest() {
        if (getRoverXPoint() > 0)  {
            setRoverXPoint(getRoverXPoint() - 1);
        }
    }

    private void moveSouth() {
        if (getRoverYPoint() > 0) {
            setRoverYPoint(getRoverYPoint() - 1);
        }
    }

    private void moveEast() {
        if (getRoverXPoint() < getMapX()) {
            setRoverXPoint(getRoverXPoint() + 1);
        }
    }

    private void moveNorth() {
        if (getRoverYPoint() < getMapY()) {
            setRoverYPoint(getRoverYPoint() + 1);
        }
    }


    public void turnRight() {
        if (getIndexOfCompass() == (compass.length - 1)) {
            setDirection('N');
        }
        else {
            setDirection(compass[getIndexOfCompass() + 1]);
        }
    }

    public void turnLeft() {
        if (getIndexOfCompass() == 0) {
            setDirection('W');
        }
        else {
            setDirection(compass[getIndexOfCompass() - 1]);
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
        return getRoverXPoint() + " " + getRoverYPoint() + " " + getDirection();
    }


}
