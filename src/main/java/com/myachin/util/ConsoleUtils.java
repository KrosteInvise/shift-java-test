package com.myachin.util;

public class ConsoleUtils {
    private static final String RED_BOLD = "\033[1;91m";
    private static final String RESET = "\u001B[0m";

    public static void printError(String message) {
        System.err.println("\n" + RED_BOLD + "!!!!----> " + message + RESET);
    }
}
