package com.kata.rovermarsjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class RoverMarsJava {

    private static ArrayList instructions = new ArrayList();
    private static Map map;



    public static void main(String[] args) {
        openFile();
        setMap();
    }


    private static void openFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("src/input.txt")));
            saveInputinArray(reader);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void saveInputinArray(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            instructions.add(line);
        }
    }

    private static void setMap() {
        String values = (String) instructions.get(0);
        String[] mapValues = values.split(" ");
        int x =  Integer.parseInt(mapValues[0]);
        int y =  Integer.parseInt(mapValues[1]);
        map = new Map(x, y);
    }


}
