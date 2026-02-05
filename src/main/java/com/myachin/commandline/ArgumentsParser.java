package com.myachin.commandline;

import java.nio.file.Path;
import java.util.ArrayList;

public class ArgumentsParser {

    public static ArgumentsConfig parse(String[] args) {

        var filesToParse =  new ArrayList<Path>();
        var outputDirectory = Path.of("./output");
        var shortInfo = false;
        var fullInfo = false;
        var appendMode = false;

        for (int i = 0; i < args.length; i++) {

            String arg = args[i];

            switch (arg) {
                case "-o" -> {
                    if(i+1 >= args.length) {
                        throw new IllegalArgumentException("Argument -o requires a path");
                    }
                    outputDirectory = Path.of(args[++i]);
                }
                case "-s" -> {
                    shortInfo = true;
                }
                case "-f" -> {
                    fullInfo = true;
                }
                case "-a" -> {
                    appendMode = true;
                }
                default -> {
                    if(arg.startsWith("-")) {
                        throw new IllegalArgumentException("Non-existing argument: " + arg);
                    }
                    filesToParse.add(Path.of(arg));
                }
            }
        }

        if (shortInfo && fullInfo) {
            throw new IllegalArgumentException("Can't use -s and -f arguments at the same time");
        }

        if (filesToParse.isEmpty()) {
            throw new IllegalArgumentException("No input files specified");
        }

        return new ArgumentsConfig(
                filesToParse,
                outputDirectory,
                shortInfo,
                fullInfo,
                appendMode
        );
    }
}
