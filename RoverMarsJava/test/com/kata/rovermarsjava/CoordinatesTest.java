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




}