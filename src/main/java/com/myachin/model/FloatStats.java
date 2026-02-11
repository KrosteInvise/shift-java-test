package com.myachin.model;

import lombok.Getter;

@Getter
public class FloatStats extends NumbersStats<Double> {
    private Double minValue = Double.MAX_VALUE;
    private Double maxValue = -Double.MAX_VALUE;
    private Double sum = 0.0;

    @Override
    public void accept(Double value) {
        count++;
        minValue = Math.min(minValue, value);
        maxValue = Math.max(maxValue, value);
        sum += value;
    }
}
