package com.myachin;

import com.myachin.commandline.model.ArgumentsConfig;
import com.myachin.commandline.utility.ArgumentsParser;
import com.myachin.fileprocessing.utility.FileParser;
import com.myachin.fileprocessing.utility.OutputWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArgumentsConfig config = ArgumentsParser.parse(args);
            OutputWriter writer = new OutputWriter(config.getOutputDirectory(), config.getPrefix(), config.isAppendMode());

            FileParser fileParser = new FileParser(writer);
            fileParser.parseFiles(config.getFilesToParse());
            fileParser.close();

            System.out.println("Complete successfully");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}