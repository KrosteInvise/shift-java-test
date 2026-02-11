package com.myachin.io;

import com.myachin.model.ArgumentsConfig;

import java.nio.file.Path;
import java.util.ArrayList;

public final class ArgumentsParser {

    private static String RED = "\u001B[31m";

    public static ArgumentsConfig parse(String[] args) {
        var filesToParse =  new ArrayList<Path>();
        var outputDirectory = Path.of("./output");
        var prefix = "";
        var shortStats = false;
        var fullStats = false;
        var appendMode = false;

        for (int i = 0; i < args.length; i++) {

            String arg = args[i];

            switch (arg) {
                case "-o" -> {
                    if(i++ >= args.length) {
                        throw new IllegalArgumentException("Argument -o requires a path");
                    }
                    outputDirectory = Path.of(args[i]);
                }
                case "-p" -> {
                    if(i++ >= args.length) {
                        throw new IllegalArgumentException("Argument -p requires a prefix");
                    }
                    prefix = args[i];
                }
                case "-s" -> shortStats = true;
                case "-f" -> fullStats = true;
                case "-a" -> appendMode = true;
                default -> {
                    if(arg.startsWith("-")) {
                        throw new IllegalArgumentException("Non-existing argument: " + arg);
                    }
                    filesToParse.add(Path.of(arg));
                }
            }
        }

        if (shortStats && fullStats) {
            throw new IllegalArgumentException("Can't use -s and -f arguments at the same time");
        }

        if (filesToParse.isEmpty()) {
            throw new IllegalArgumentException(RED + "No input files specified");
        }

        return new ArgumentsConfig(
                filesToParse,
                outputDirectory,
                prefix,
                shortStats,
                fullStats,
                appendMode
        );
    }
}