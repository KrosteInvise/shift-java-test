package com.myachin.io;

import com.myachin.model.LineType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumMap;
import java.util.Map;

public class OutputWriter {

    private final Path outputDirectory;
    private final String prefix;
    private final boolean append;

    private final Map<LineType, BufferedWriter> writers = new EnumMap<>(LineType.class);

    public OutputWriter(Path outputDirectory, String prefix, boolean append) {
        this.outputDirectory = outputDirectory;
        this.prefix = prefix;
        this.append = append;
    }

    public void write(String line, LineType type) {
        try {
            BufferedWriter writer = writers.get(type);
            if (writer == null) {
                writer = createWriter(type);
                writers.put(type, writer);
            }
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write line: " + e.getMessage());
        }
    }

    private BufferedWriter createWriter(LineType type) throws IOException {
        Files.createDirectories(outputDirectory);
        Path filePath = outputDirectory.resolve(prefix + fileNamePostfix(type));

        return Files.newBufferedWriter(
                filePath,
                StandardOpenOption.CREATE,
                append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
    }

    private String fileNamePostfix(LineType type) {
        return switch (type) {
            case INTEGER -> "integers.txt";
            case FLOAT -> "floats.txt";
            case STRING -> "strings.txt";
        };
    }

    public void close() {
        for (BufferedWriter writer : writers.values()) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Failed to close writer: " + e.getMessage());
            }
        }
    }
}