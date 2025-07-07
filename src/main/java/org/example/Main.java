package org.example;

import org.example.parser.ArgsParser;
import org.example.parser.DataType;
import org.example.parser.DataTypesParser;
import org.example.service.FileStatsService;
import org.example.service.FileWriterService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("No arguments found");
        }

        ArgsParser argsParser = ArgsParser.parse(args);

        DataTypesParser dataTypesParser = new DataTypesParser();
        FileStatsService fileStatsService = new FileStatsService();
        FileWriterService fileWriterService = new FileWriterService(argsParser);

        for (String file : argsParser.getFiles()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();

                while (line != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;

                    DataType dataType = dataTypesParser.getType(line);
                    fileWriterService.write(dataType, line);
                    fileStatsService.update(dataType, line);

                    line = bufferedReader.readLine();
                }


            } catch (IOException e) {
                System.out.printf("Error occurred while reading file %s: %s", file, e.getMessage());
            }
        }

        fileStatsService.printStats(argsParser.isFull());
    }
}