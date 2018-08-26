package com.kata.rovermarsjava;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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




}