package org.example.service;

import org.example.parser.DataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileStatsService {
    private final List<Long> integers = new ArrayList<>();
    private final List<Double> floats = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();

    public void update(DataType dataType, String value) {
        switch (dataType) {
            case INTEGER -> integers.add(Long.parseLong(value));
            case FLOAT -> floats.add(Double.parseDouble(value));
            case STRING -> strings.add(value);
        }
    }

    public void printStats(boolean isFull) {
        if (!integers.isEmpty()) printInts(isFull);
        if (!floats.isEmpty()) printFloats(isFull);
        if (!strings.isEmpty()) printStrings(isFull);
    }

    private void printInts(boolean isFull) {
        System.out.println("Integers size: " + integers.size());
        if (isFull) {
            long sum = integers.stream().mapToLong(Long::longValue).sum();
            System.out.println(" Min: " + Collections.min(integers));
            System.out.println(" Max: " + Collections.max(integers));
            System.out.println(" Average: " + (double) (sum / integers.size()));
            System.out.println(" Sum: " + sum);
        }
    }

    private void printFloats(boolean isFull) {
        System.out.println("Floats size: " + floats.size());
        if (isFull) {
            double sum = floats.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("  Min: " + Collections.min(floats));
            System.out.println("  Max: " + Collections.max(floats));
            System.out.println("  Sum: " + sum);
            System.out.println("  Average: " + sum / floats.size());
        }
    }

    private void printStrings(boolean isFull) {
        System.out.println("Strings size: " + strings.size());
        if (isFull) {
            int min = strings.stream().mapToInt(String::length).min().orElse(0);
            int max = strings.stream().mapToInt(String::length).max().orElse(0);
            System.out.println("  Shortest string: " + min + " symbols");
            System.out.println("  Longest string: " + max + " symbols");
        }
    }
}
