package com.myachin.commandline;

import java.nio.file.Path;
import java.util.ArrayList;

public class ArgumentsParser {

    public static ArgumentsConfig parse(String[] args) {

        var filesToParse =  new ArrayList<Path>();
        var outputDirectory = Path.of("./output");

        for (int i = 0; i < args.length; i++) {

            String arg = args[i];

            switch (arg) {
                case "-o" -> {
                    if(i+1 >= args.length) {
                        throw new IllegalArgumentException("Arguement -o requires a path!");
                    }
                    outputDirectory = Path.of(args[++i]);
                }
                default -> {
                    if(arg.startsWith("-")) {
                        throw new IllegalArgumentException("Non-existing argument: " + arg);
                    }
                    filesToParse.add(Path.of(arg));
                }
            }
        }

        if (filesToParse.isEmpty()) {
            throw new IllegalArgumentException("No input files specified");
        }

        return new ArgumentsConfig(
                filesToParse,
                outputDirectory
        );
    }

}
