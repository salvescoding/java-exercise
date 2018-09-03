package com.kata.rovermarsjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private Coordinates coordinates;

    @BeforeEach
    void setUp() {
        Point x = new Point(1, 5);
        Point y = new Point(2, 5);
        coordinates = new Coordinates(x, y, 'N');
    }

    @Test
    void shouldInstanceRoverInitialPositionWithCorrectXAndY() {
        assertEquals(coordinates.getRoverXPoint(), 1);
        assertEquals(coordinates.getRoverYPoint(), 2);
    }

    @Test
    void shouldInstanceWithTheCorrectOrientation() {
        assertEquals('N', coordinates.getDirection());
    }

    @Test
    void shouldInstanceWithMapXAndYParams(){
        assertEquals(5, coordinates.getMapX());
        assertEquals(5, coordinates.getMapY());
    }

    @Test
    void positionYShouldIncreaseWhenMoveWithOrientationNorth() {
        int expected = coordinates.getRoverYPoint() + 1;
        coordinates.setDirection('N');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getRoverYPoint());
    }

    @Test
    void positionXShouldIncreaseWhenMoveWithOrientationEast() {
        int expected = coordinates.getRoverXPoint() + 1;
        coordinates.setDirection('E');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getRoverXPoint());
    }

    @Test
    void positionYShouldDecreaseWhenMoveWithOrientationSouth() {
        int expected = coordinates.getRoverYPoint() - 1;
        coordinates.setDirection('S');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getRoverYPoint());
    }

    @Test
    void positionXShouldDecreaseWhenMoveWithOrientationWest() {
        int expected = coordinates.getRoverXPoint() - 1;
        coordinates.setDirection('W');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getRoverXPoint());
    }

    @Test
    void orientationNorthShouldChangeToEastWhenTurnRight() {
        char expected = 'E';
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationEastShouldChangeToSouthWhenTurnRight() {
        char expected = 'S';
        coordinates.setDirection('E');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationSouthShouldChangeToWestWhenTurnRight() {
        char expected = 'W';
        coordinates.setDirection('S');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationWestShouldChangeToNorthWhenTurnRight() {
        char expected = 'N';
        coordinates.setDirection('W');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationNorthShouldChangeToNorthAfter360Degrees() {
        char expected = 'N';
        coordinates.turnRight();
        coordinates.turnRight();
        coordinates.turnRight();
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationNorthShouldChangeToWestWhenTurnLeft() {
        char expected = 'W';
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationWestShouldChangeToSouthWhenTurnLeft() {
        char expected = 'S';
        coordinates.setDirection('W');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationSouthShouldChangeToEastWhenTurnLeft() {
        char expected = 'E';
        coordinates.setDirection('S');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    void orientationEastShouldChangeToNorthWhenTurnLeft() {
        char expected = 'N';
        coordinates.setDirection('E');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }



}