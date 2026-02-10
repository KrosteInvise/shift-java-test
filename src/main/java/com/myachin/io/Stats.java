package com.myachin.io;

import com.myachin.model.LineType;
import com.myachin.model.NumbersStats;
import com.myachin.model.StringStats;

public class Stats {

    private long intCount = 0;
    private long floatCount = 0;
    private long stringCount = 0;

    private final NumbersStats intStats = new NumbersStats();
    private final NumbersStats floatStats = new NumbersStats();
    private final StringStats stringStats = new StringStats();

    public void accept(LineType type, String line) {
        switch (type) {
            case INTEGER -> {
                intCount++;
                intStats.accept(Long.parseLong(line));
            }
            case FLOAT -> {
                floatCount++;
                floatStats.accept(Double.parseDouble(line));
            }
            case STRING -> {
                stringCount++;
                stringStats.accept(line);
            }
        }
    }

    public void printShortStats() {
        System.out.println("---- Short stats ----");
        if (intCount > 0) System.out.println("Integers: " + intCount);
        if (floatCount > 0) System.out.println("Floats: " + floatCount);
        if (stringCount > 0) System.out.println("Strings: " + stringCount);
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

    private void printNumberStats(NumbersStats stats) {
        System.out.println("  count = " + stats.getCount());
        System.out.println("  min = " + stats.getMinValue());
        System.out.println("  max = " + stats.getMaxValue());
        System.out.println("  sum = " + stats.getSum());
        System.out.println("  avg = " + stats.getAverage());
    }
}