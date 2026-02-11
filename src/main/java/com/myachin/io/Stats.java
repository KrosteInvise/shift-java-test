package com.myachin.io;

import com.myachin.model.*;

public class Stats {
    private final NumbersStats<Long> intStats = new IntegerStats();
    private final NumbersStats<Double> floatStats = new FloatStats();
    private final StringStats stringStats = new StringStats();

    public void accept(LineType type, String line) {
        switch (type) {
            case INTEGER -> intStats.accept(Long.parseLong(line));
            case FLOAT -> floatStats.accept(Double.parseDouble(line));
            case STRING -> stringStats.accept(line);
        }
    }

    public void printShortStats() {
        System.out.println("---- Short stats ----");
        if (intStats.hasData()) System.out.println("Integers: " + intStats.getCount());
        if (floatStats.hasData()) System.out.println("Floats: " + floatStats.getCount());
        if (stringStats.hasData()) System.out.println("Strings: " + stringStats.getCount());
    }

    public void printFullStats() {
        System.out.println("---- Full stats ----");

        if (intStats.hasData()) {
            System.out.println("INTEGER:");
            printNumberStats(intStats);
        }

        if (floatStats.hasData()) {
            System.out.println("FLOAT:");
            printNumberStats(floatStats);
        }

        if (stringStats.hasData()) {
            System.out.println("STRING:");
            System.out.println("  count = " + stringStats.getCount());
            System.out.println("  min length = " + stringStats.getMinLength());
            System.out.println("  max length = " + stringStats.getMaxLength());
        }
    }

    private void printNumberStats(NumbersStats<?> stats) {
        System.out.println("  count = " + stats.getCount());
        System.out.println("  min = " + stats.getMinValue());
        System.out.println("  max = " + stats.getMaxValue());
        System.out.println("  sum = " + stats.getSum());
        System.out.println("  avg = " + stats.getAverage());
    }
}