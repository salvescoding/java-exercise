package com.kata.rovermarsjava;

class Rover {

    private static final char[] compass = new char[]{'N', 'E', 'S', 'W'};
    private int x;
    private int y;
    private char orientation;
    private Map map;

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public char getOrientation() { return orientation; }

    public void setOrientation(char orientation) { this.orientation = orientation; }

    public Map getMap() { return map; }

    public void setMap(Map map) { this.map = map; }

    public Rover(int x, int y, char orientation, Map map) {
        setX(x);
        setY(y);
        setOrientation(orientation);
        setMap(map);
    }

    public void receiveCommands(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            runCommand(command);
        }
    }

    public String getPosition() {
        return getX() + " " + getY() + " " + getOrientation();
    }

    private void runCommand(char command) {
        switch (command) {
            case 'M':
                move();
                break;
            case 'L':
                rotateLeft();
                break;
            case 'R':
                rotateRight();
                break;
        }
    }

    private void rotateRight() {
        if (getIndexOfCompass() == (compass.length - 1)) {
            setOrientation('N');
        }
        else {
            setOrientation(compass[getIndexOfCompass() + 1]);
        }
    }

    private void rotateLeft() {
        if (getIndexOfCompass() == 0) {
            setOrientation('W');
        }
        else {
            setOrientation(compass[getIndexOfCompass() - 1]);
        }
    }

    private void move() {
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
        if (this.x > 0)  {
            setX(this.x - 1);
        }
    }

    private void moveSouth() {
        if (this.y > 0) {
            setY(this.y - 1);
        }
    }

    private void moveEast() {
        if (this.x < map.getX()) {
            setX(this.x + 1);
        }
    }

    private void moveNorth() {
        if (this.y < map.getY()) {
            setY(this.y + 1);
        }
    }

    private int getIndexOfCompass() {
        int index = 0;
        for (int i = 0; i < compass.length; i++) {
            if (orientation == compass[i]) {
                index = i;
            }
        }
        return index;
    }


}
