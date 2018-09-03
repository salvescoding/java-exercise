package com.kata.rovermarsjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;
    private Coordinates coordinates;

    @BeforeEach
    void beforeRoverTest() {
        Point x = new Point(1, 5);
        Point y = new Point(2, 5);
        coordinates = new Coordinates(x, y, 'N');
        rover = new Rover(coordinates);
    }

    @Test
    void roverGetsInitializedWithCorrectParams() {
        assertSame(rover.getCoordinates(), coordinates);
    }

    @Test
    void roverYLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingNorth() {
        int expected = rover.getCoordinates().getRoverYPoint() + 1;
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getRoverYPoint());
    }

    @Test
    void roverYLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingSouth() {
        int expected = rover.getCoordinates().getRoverYPoint() - 1;
        rover.getCoordinates().setDirection('S');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getRoverYPoint());
    }

    @Test
    void roverXLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingEast() {
        int expected = rover.getCoordinates().getRoverXPoint() + 1;
        rover.getCoordinates().setDirection('E');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getRoverXPoint());
    }

    @Test
    void roverXLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingWest() {
        int expected = rover.getCoordinates().getRoverXPoint() - 1;
        rover.getCoordinates().setDirection('W');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getCoordinates().getRoverXPoint());
    }

    @Test
    void roverShouldGetFinalOutcomeCorrectForTestCaseOne() {
        rover.receiveCommands("LMLMLMLMM");
        assertEquals(1, rover.getCoordinates().getRoverXPoint());
        assertEquals(3, rover.getCoordinates().getRoverYPoint());
        assertEquals('N', rover.getCoordinates().getDirection());
    }

    @Test
    void roverShouldGetFinalOutcomeCorrectForTestCaseTwo() {
        Point x = new Point(3, 5);
        Point y = new Point(3, 5);
        Coordinates coordinatesTwo = new Coordinates(x,y,'E');
        Rover roverTwo = new Rover(coordinatesTwo);
        roverTwo.receiveCommands("MMRMMRMRRM");
        assertEquals(5, roverTwo.getCoordinates().getRoverXPoint());
        assertEquals(1, roverTwo.getCoordinates().getRoverYPoint());
        assertEquals('E', roverTwo.getCoordinates().getDirection());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingNorth() {
        rover.receiveCommands("LMLMLMLMMMMMR");
        assertEquals(1, rover.getCoordinates().getRoverXPoint());
        assertEquals(5, rover.getCoordinates().getRoverXPoint());
        assertEquals('E', rover.getCoordinates().getDirection());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingEast() {
        rover.receiveCommands("RMMMMM");
        assertEquals(5, rover.getCoordinates().getRoverXPoint());
        assertEquals(2, rover.getCoordinates().getRoverYPoint());
        assertEquals('E', rover.getCoordinates().getDirection());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingMinSouthAndMinWest() {
        rover.receiveCommands("LMMLMMMLMMLM");
        assertEquals(2, rover.getCoordinates().getRoverXPoint());
        assertEquals(1, rover.getCoordinates().getRoverYPoint());
        assertEquals('N', rover.getCoordinates().getDirection());
    }







}