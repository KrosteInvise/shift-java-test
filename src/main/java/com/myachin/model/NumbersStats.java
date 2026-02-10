package com.myachin.model;

import lombok.Getter;

@Getter
public class NumbersStats {

    private long count = 0;
    private double minValue = 0;
    private double maxValue = Double.MAX_VALUE;
    private double sum = 0;

    public void accept(double value) {
        count++;
        minValue = Math.min(minValue, value);
        maxValue = Math.max(maxValue, value);
        sum += value;
    }

    public double getAverage() {
        return count == 0 ? 0 : sum/count;
    }

    public boolean hasData() {
        return count > 0;
    }
}
