package com.myachin.fileprocessing.utility;

import com.myachin.fileprocessing.model.LineType;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileParser {

    public void parseFiles(List<Path> files) {
        for (var file : files) {
            parseFile(file);
        }
    }

    private void parseLine(String line, LineType type) {
        System.out.println();
    }

    private void parseFile(Path file) {
        if(!Files.exists(file)) {
            System.err.println("File does not exist: " + file);
            return;
        }

        if(!Files.isReadable(file)) {
            System.err.println("Unreadable file: " + file);
        }

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                LineType type = LineTypeClassifier.classify(line);
                parseLine(line, type);
            }
        }
        catch (IOException e) {
            System.err.println("Failed to read file: " + file + e.getMessage());
        }
    }
}
