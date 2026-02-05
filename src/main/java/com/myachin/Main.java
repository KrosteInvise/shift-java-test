package com.myachin;

import com.myachin.commandline.ArgumentsConfig;
import com.myachin.commandline.ArgumentsParser;

public class Main {
    public static void main(String[] args) {

        try {
            ArgumentsConfig config = ArgumentsParser.parse(args);
            System.out.println("Files: " + config.getFilesToParse());

            for (var arg : args)
                System.out.println(arg);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }
}
