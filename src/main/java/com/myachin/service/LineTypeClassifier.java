package com.myachin.service;

import com.myachin.model.LineType;

public final class LineTypeClassifier {

    public static LineType classify(String line) {
        String field = line.trim();

        if(field.isEmpty())
            return LineType.STRING;

        if(isWholeNumber(field))
            return LineType.INTEGER;

        if(isDecimalNumber(field))
            return LineType.FLOAT;

        return LineType.STRING;
    }

    private static boolean isWholeNumber(String field) {
        try {
            Long.parseLong(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDecimalNumber(String field) {
        try {
            Double.parseDouble(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}