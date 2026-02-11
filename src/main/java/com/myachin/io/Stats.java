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
            System.out.println("  Count = " + stringStats.getCount());
            System.out.println("  Minimum length = " + stringStats.getMinLength());
            System.out.println("  Maximum length = " + stringStats.getMaxLength());
        }
    }

    private void printNumberStats(NumbersStats<?> stats) {
        System.out.println("  Count = " + stats.getCount());
        System.out.println("  Minimum value = " + stats.getMinValue());
        System.out.println("  Maximum value = " + stats.getMaxValue());
        System.out.println("  Sum = " + stats.getSum());
        System.out.println("  Average = " + stats.getAverage());
    }
}