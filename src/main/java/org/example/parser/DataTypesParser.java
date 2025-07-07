package org.example.parser;

public class DataTypesParser {
    public DataType getType(String value) {
        try {
            Long.parseLong(value);
            return DataType.INTEGER;
        } catch (NumberFormatException ignored) {}

        try {
            Double.parseDouble(value);
            return DataType.FLOAT;
        } catch (NumberFormatException ignored) {}

        return DataType.STRING;
    }
}
