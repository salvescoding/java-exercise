package com.kata.rovermarsjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private Map map;
    private Coordinates coordinates;

    @BeforeEach
    public void setUp() {
        map = new Map(5, 5);
        coordinates = new Coordinates(1, 2, 'N', map);
    }

    @Test
    public void shouldInstanceWithXandY() {
        assertEquals(coordinates.getX(), 1);
        assertEquals(coordinates.getY(), 2);
    }

    @Test
    public void shouldInstanceWithTheCorrectOrientation() {
        assertEquals('N', coordinates.getDirection());
    }

    @Test
    public void shouldInstanceWithMapXAndYParams(){
        assertEquals(5, coordinates.getMap().getX());
        assertEquals(5, coordinates.getMap().getY());
    }

    @Test
    public void positionYShouldIncreaseWhenMoveWithOrientationNorth() {
        int expected = coordinates.getY() + 1;
        coordinates.setDirection('N');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getY());
    }

    @Test
    public void positionXShouldIncreaseWhenMoveWithOrientationEast() {
        int expected = coordinates.getX() + 1;
        coordinates.setDirection('E');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getX());
    }

    @Test
    public void positionYShouldDecreaseWhenMoveWithOrientationSouth() {
        int expected = coordinates.getY() - 1;
        coordinates.setDirection('S');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getY());
    }

    @Test
    public void positionXShouldDecreaseWhenMoveWithOrientationWest() {
        int expected = coordinates.getX() - 1;
        coordinates.setDirection('W');
        coordinates.move(coordinates.getDirection());
        assertEquals(expected, coordinates.getX());
    }

    @Test
    public void orientationNorthShouldChangeToEastWhenTurnRight() {
        char expected = 'E';
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationEastShouldChangeToSouthWhenTurnRight() {
        char expected = 'S';
        coordinates.setDirection('E');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationSouthShouldChangeToWestWhenTurnRight() {
        char expected = 'W';
        coordinates.setDirection('S');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationWestShouldChangeToNorthWhenTurnRight() {
        char expected = 'N';
        coordinates.setDirection('W');
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationNorthShouldChangeToNorthAfter360Degrees() {
        char expected = 'N';
        coordinates.turnRight();
        coordinates.turnRight();
        coordinates.turnRight();
        coordinates.turnRight();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationNorthShouldChangeToWestWhenTurnLeft() {
        char expected = 'W';
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationWestShouldChangeToSouthWhenTurnLeft() {
        char expected = 'S';
        coordinates.setDirection('W');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationSouthShouldChangeToEastWhenTurnLeft() {
        char expected = 'E';
        coordinates.setDirection('S');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }

    @Test
    public void orientationEastShouldChangeToNorthWhenTurnLeft() {
        char expected = 'N';
        coordinates.setDirection('E');
        coordinates.turnLeft();
        assertEquals(expected, coordinates.getDirection());
    }



}