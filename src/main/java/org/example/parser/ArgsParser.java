package org.example.parser;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {
    private final String outputDirectory;
    private final String prefix;
    private final boolean isFull;
    private final boolean isShort;
    private final boolean append;
    private final List<String> files;

    public static ArgsParser parse(String[] args) {
        String outputDirectory = ".";
        String prefix = "";
        boolean isFull = false;
        boolean isShort = false;
        boolean append = false;
        List<String> files = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o" -> outputDirectory = args[++i];
                case "-p" -> prefix = args[++i];
                case "-f" -> isFull = true;
                case "-s" -> isShort = true;
                case "-a" -> append = true;
                default -> files.add(args[i]);
            }
        }

        if (!isShort && !isFull) {
            isShort = true;
        }

        return new ArgsParser(outputDirectory, prefix, isFull, isShort, append, files);
    }

    public ArgsParser(String outputDirectory, String prefix, boolean isFull, boolean isShort, boolean append, List<String> files) {
        this.outputDirectory = outputDirectory;
        this.prefix = prefix;
        this.isFull = isFull;
        this.isShort = isShort;
        this.append = append;
        this.files = files;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isFull() {
        return isFull;
    }

    public boolean isShort() {
        return isShort;
    }

    public boolean isAppend() {
        return append;
    }
}