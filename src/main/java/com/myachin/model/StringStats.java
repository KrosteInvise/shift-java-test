package com.myachin.model;

import lombok.Getter;

@Getter
public class StringStats {

    private long count = 0;
    private int minLength = 0;
    private int maxLength = 0;

    public void accept(String value) {
        count++;
        int lenght = value.length();
        minLength = Math.min(minLength, lenght);
        maxLength = Math.max(maxLength, lenght);
    }

    public boolean hasData() {
        return count > 0;
    }
}
