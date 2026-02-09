package com.myachin.fileprocessing.utility;

import com.myachin.fileprocessing.model.LineType;

public final class LineTypeClassifier {

    public static LineType classify(String line) {
        String field = line.trim();

        if(field.isEmpty())
            return LineType.STRING;

        if(isInteger(field) || isLong(field))
            return LineType.INTEGER;

        if(isFloat(field))
            return LineType.FLOAT;

        return LineType.STRING;
    }

    private static boolean isInteger(String field) {
        try {
            Integer.parseInt(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isLong(String field) {
        try {
            Long.parseLong(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String field) {
        try {
            Float.parseFloat(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}