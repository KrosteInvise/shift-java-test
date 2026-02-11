package com.myachin.model;

import lombok.Getter;

@Getter
public class IntegerStats extends NumbersStats<Long> {
    private Long minValue = Long.MAX_VALUE;
    private Long maxValue = Long.MIN_VALUE;
    private Long sum = 0L;

    @Override
    public void accept(Long value) {
        count++;
        minValue = Math.min(minValue, value);
        maxValue = Math.max(maxValue, value);
        sum += value;
    }
}
