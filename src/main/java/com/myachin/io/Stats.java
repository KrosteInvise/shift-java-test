package com.myachin.io;

import com.myachin.model.LineType;

import java.util.EnumMap;
import java.util.Map;

public class Stats {

    private final Map<LineType, Long> counters = new EnumMap<>(LineType.class);

    public Stats() {
        for (var type : LineType.values()) {
            counters.put(type, 0L);
        }
    }

    public void incrementType(LineType type) {
        counters.put(type, counters.get(type) + 1);
    }

    public void printShortStats() {
        System.out.println("---- Short Stats ----");
        for (var type : LineType.values()) {
            long count = counters.get(type);
            if(count > 0) {
                System.out.printf("%s : %d%n", type, count);
            }
        }
    }
}