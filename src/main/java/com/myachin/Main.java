package com.myachin;

import com.myachin.commandline.model.ArgumentsConfig;
import com.myachin.commandline.utility.ArgumentsParser;
import com.myachin.fileprocessing.utility.FileParser;

public class Main {
    public static void main(String[] args) {

        try {
            ArgumentsConfig config = ArgumentsParser.parse(args);
            System.out.println("Files: " + config.getFilesToParse());

            FileParser fileParser = new FileParser();
            fileParser.parseFiles(config.getFilesToParse());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }
}