package com.kata.rovermarsjava;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;
    private Coordinates coordinates;
    private Map map;

    @BeforeEach
    public void beforeRoverTest() {
        map = new Map(5,5);
        coordinates = new Coordinates(1, 2, 'N', map);
        rover = new Rover(coordinates);
    }

    @Test
    public void roverGetsInitializedWithCorrectParams() {
        assertSame(rover.getCoordinates(), coordinates);
    }

    @Test
    public void roverYLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingNorth() {
        int expected = rover.getCoordinates().getY() + 1;
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getY());
    }

    @Test
    public void roverYLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingSouth() {
        int expected = rover.getCoordinates().getY() - 1;
        rover.getCoordinates().setDirection('S');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getY());
    }

    @Test
    public void roverXLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingEast() {
        int expected = rover.getCoordinates().getX() + 1;
        rover.getCoordinates().setDirection('E');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getX());
    }

    @Test
    public void roverXLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingWest() {
        int expected = rover.getCoordinates().getX() - 1;
        rover.getCoordinates().setDirection('W');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getX());
    }

    @Test
    public void roverShouldGetFinalOutcomeCorrectForTestCaseOne() {
        rover.receiveCommands("LMLMLMLMM");
        assertEquals(1, rover.getCoordinates().getX());
        assertEquals(3, rover.getCoordinates().getY());
        assertEquals('N', rover.getCoordinates().getDirection());
    }

    @Test
    public void roverShouldGetFinalOutcomeCorrectForTestCaseTwo() {
        Coordinates coordinatesTwo = new Coordinates(3,3,'E', map);
        Rover roverTwo = new Rover(coordinatesTwo);
        roverTwo.receiveCommands("MMRMMRMRRM");
        assertEquals(5, roverTwo.getCoordinates().getX());
        assertEquals(1, roverTwo.getCoordinates().getY());
        assertEquals('E', roverTwo.getCoordinates().getDirection());
    }







}