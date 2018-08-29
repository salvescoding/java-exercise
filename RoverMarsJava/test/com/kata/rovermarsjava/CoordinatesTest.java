package com.kata.rovermarsjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private Coordinates coordinates;

    @BeforeEach
    void setUp() {
        Map map = new Map(5, 5);
        coordinates = new Coordinates(1, 2, 'N', map);
    }

    @Test
    void shouldInstanceWithXAndY() {
        assertEquals(coordinates.getX(), 1);
        assertEquals(coordinates.getY(), 2);
    }

    @Test
    void shouldInstanceWithTheCorrectOrientation() {
        assertEquals('N', coordinates.getDirection());
    }

    @Test
    void shouldInstanceWithMapXAndYParams(){
        assertEquals(5, coordinates.getMap().getX());
        assertEquals(5, coordinates.getMap().getY());
    }

    @Test
    void positionYShouldIncreaseWhenMoveWithOrientationNorth() {
        int expected = coordinates.getY() + 1;
        coordinates.setDirection('N');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getY());
    }

    @Test
    void positionXShouldIncreaseWhenMoveWithOrientationEast() {
        int expected = coordinates.getX() + 1;
        coordinates.setDirection('E');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getX());
    }

    @Test
    void positionYShouldDecreaseWhenMoveWithOrientationSouth() {
        int expected = coordinates.getY() - 1;
        coordinates.setDirection('S');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getY());
    }

    @Test
    void positionXShouldDecreaseWhenMoveWithOrientationWest() {
        int expected = coordinates.getX() - 1;
        coordinates.setDirection('W');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getX());
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