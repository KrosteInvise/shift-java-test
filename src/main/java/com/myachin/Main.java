package com.myachin;

import com.myachin.commandline.ArgumentsConfig;
import com.myachin.commandline.ArgumentsParser;

public class Main {
    public static void main(String[] args) {

        try {
            ArgumentsConfig config = ArgumentsParser.parse(args);
            System.out.println("Files: " + config.getFilesToParse());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }
}
