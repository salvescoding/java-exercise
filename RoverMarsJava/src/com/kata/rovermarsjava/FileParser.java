package com.kata.rovermarsjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private String filePath;
    private List<String> fileContent = new ArrayList<>();

    public FileParser(String filePath) {
        this.filePath = filePath;
    }


    public List<String> extractInputFromFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File("src/input.txt")));
            saveFileInputIntoFileContent(reader);
        }
        catch (IOException e) {
            System.out.println("File not found!");
        }
        return this.fileContent;
    }

    private void saveFileInputIntoFileContent(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.add(line);
        }
    }
}
