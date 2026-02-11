package com.myachin.io;

import com.myachin.model.ArgumentsConfig;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ArgumentsParser {

    private static final Set<String> OPTIONS =
            Set.of("-o", "-p", "-a", "-s", "-f");

    private static boolean isOption(String arg) {
        return OPTIONS.contains(arg);
    }

    public static ArgumentsConfig parse(String[] args) {
        List<Path> filesToParse =  new ArrayList<Path>();
        Path outputDirectory = Path.of(".");
        String prefix = "";
        boolean shortStats = false;
        boolean fullStats = false;
        boolean appendMode = false;

        for (int i = 0; i < args.length; i++) {

            String arg = args[i];

            switch (arg) {
                case "-o" -> {
                    if(i+1 >= args.length || isOption(args[i+1])) {
                        throw new IllegalArgumentException("Argument -o requires a path");
                    }
                    outputDirectory = Path.of(args[++i]);
                }
                case "-p" -> {
                    if(i+1 >= args.length || isOption(args[i+1])) {
                        throw new IllegalArgumentException("Argument -p requires a prefix");
                    }
                    prefix = args[++i];
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
            throw new IllegalArgumentException("No input files specified");
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