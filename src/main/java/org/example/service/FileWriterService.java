package org.example.service;

import org.example.parser.ArgsParser;
import org.example.parser.DataType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class FileWriterService {
    private final Map<DataType, BufferedWriter> writers = new EnumMap<>(DataType.class);
    private final String dir;
    private final String prefix;
    private final boolean isAppend;

    public FileWriterService(ArgsParser parser) {
        this.dir = parser.getOutputDirectory();
        this.prefix = parser.getPrefix();
        this.isAppend = parser.isAppend();
    }

    public void write(DataType type, String value) {
        try {
            BufferedWriter writer = writers.computeIfAbsent(type, this::createBufferedWriter);
            writer.write(value);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.printf("Error occurred while writing %s: %s", value, e.getMessage());
        }
    }

    private BufferedWriter createBufferedWriter(DataType dataType) {
        String filename = String.format("%s%s%s.txt", dir, File.separator, prefix + dataType.name().toLowerCase());

        try {
            return new BufferedWriter(new FileWriter(filename, isAppend));
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while creating file: " + filename, e);
        }
    }
}
