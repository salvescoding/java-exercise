package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private BibliotecaApp biblioApp;
    private Book books;

    @Before
    public void setUp() {
        biblioApp = new BibliotecaApp();

    }


    @Test
    public void welcomeMessage() {
        assertEquals(1, 1);
    }
}
