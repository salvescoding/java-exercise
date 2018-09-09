package com.kata.rovermarsjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;
    private Map map;

    @BeforeEach
    void beforeRoverTest() {
        map = new Map(5,5);
        int x = 1;
        int y = 2;
        rover = new Rover(x, y, 'N', map);
    }



    @Test
    void roverYLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingNorth() {
        int expected = rover.getY() + 1;
        rover.receiveCommands("M");
        assertEquals(expected, rover.getY());
    }

    @Test
    void roverYLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingSouth() {
        int expected = rover.getY() - 1;
        rover.setOrientation('S');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getY());
    }

    @Test
    void roverXLocationShouldIncreaseByOneWhenReceiveSingleCommandMFacingEast() {
        int expected = rover.getX() + 1;
        rover.setOrientation('E');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getX());
    }

    @Test
    void roverXLocationShouldDecreaseByOneWhenReceiveSingleCommandMFacingWest() {
        int expected = rover.getX() - 1;
        rover.setOrientation('W');
        rover.receiveCommands("M");
        assertEquals(expected, rover.getX());
    }

    @Test
    void roverShouldGetFinalOutcomeCorrectForTestCaseOne() {
        rover.receiveCommands("LMLMLMLMM");
        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals('N', rover.getOrientation());
    }

    @Test
    void roverShouldGetFinalOutcomeCorrectForTestCaseTwo() {
        Rover roverOne = new Rover(3, 3, 'E', map);
        roverOne.receiveCommands("MMRMMRMRRM");
        assertEquals(5, roverOne.getX());
        assertEquals(1, roverOne.getY());
        assertEquals('E', roverOne.getOrientation());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingNorth() {
        rover.receiveCommands("LMLMLMLMMMMMR");
        assertEquals(1, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals('E', rover.getOrientation());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingEast() {
        rover.receiveCommands("RMMMMM");
        assertEquals(5, rover.getX());
        assertEquals(2, rover.getY());
        assertEquals('E', rover.getOrientation());
    }

    @Test
    void roverShouldNotExitTheMapGridWhenMovingMinSouthAndMinWest() {
        rover.receiveCommands("LMMLMMMLMMLM");
        assertEquals(2, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals('N', rover.getOrientation());
    }







}