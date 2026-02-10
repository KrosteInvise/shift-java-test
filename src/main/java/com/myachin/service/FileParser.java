package com.myachin.service;

import com.myachin.io.Stats;
import com.myachin.io.OutputWriter;
import com.myachin.model.LineType;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
public class FileParser {

    private final OutputWriter writer;
    private final Stats stats;

    public void parseFiles(List<Path> files) {
        for (var file : files) {
            parseFile(file);
        }
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
                writer.write(line, type);
                stats.incrementType(type);
            }
        }
        catch (IOException e) {
            System.err.println("Failed to read file: " + file + e.getMessage());
        }
    }

    public void close() {
        writer.close();
    }
}