package com.myachin.model;

import lombok.Getter;

@Getter
public abstract class NumbersStats<T extends Number> {

    protected long count = 0;

    public abstract void accept(T value);
    public abstract T getMinValue();
    public abstract T getMaxValue();
    public abstract T getSum();

    public double getAverage() {
        return count == 0 ? 0 : getSum().doubleValue() / count;
    }

    public boolean hasData() {
        return count > 0;
    }
}
