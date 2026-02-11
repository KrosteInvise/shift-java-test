package com.myachin;

import com.myachin.io.Stats;
import com.myachin.model.ArgumentsConfig;
import com.myachin.io.ArgumentsParser;
import com.myachin.service.FileParser;
import com.myachin.io.OutputWriter;

public class Main {
    public static void main(String[] args) {
        try {
            ArgumentsConfig config = ArgumentsParser.parse(args);

            OutputWriter writer = new OutputWriter(config.getOutputDirectory(), config.getPrefix(), config.isAppendMode());

            Stats stats = new Stats();

            FileParser fileParser = new FileParser(writer, stats);
            fileParser.parseFiles(config.getFilesToParse());
            fileParser.close();

            if (config.isShortStats()) {
                stats.printShortStats();
            } else if(config.isFullStats()) {
                stats.printFullStats();
            } else {
                System.out.println("Complete successfully");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Argument error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}