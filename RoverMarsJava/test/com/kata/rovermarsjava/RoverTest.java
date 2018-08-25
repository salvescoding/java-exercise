package com.kata.rovermarsjava;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Rover rover;

    @BeforeEach
    public void beforeRoverTest() {
        rover = new Rover(1, 2, "N");

    }

    @Test
    public void getRoverPositionX() {
        assertEquals(1, rover.getX());
    }

    @Test
    public void getRoverPositionY() {
        assertEquals(2, rover.getY());
    }

}