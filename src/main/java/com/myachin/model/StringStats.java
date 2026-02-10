package com.myachin.model;

import lombok.Getter;

@Getter
public class StringStats {

    private long count = 0;
    private int minLength = 0;
    private int maxLength = 0;

    public void accept(String value) {
        count++;
        int length = value.length();
        minLength = Math.min(minLength, length);
        maxLength = Math.max(maxLength, length);
    }

    public boolean hasData() {
        return count > 0;
    }
}
