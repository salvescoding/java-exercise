package com.kata.rovermarsjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class RoverMarsJava {

    private static ArrayList instructions = new ArrayList();



    public static void main(String[] args) {
        openFile();

    }

    public static void openFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("src/input.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                instructions.add(line);
            }
            System.out.println(instructions);

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

}
