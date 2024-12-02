package de.pascalkuehnold.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListInputReader {
    private final String filePath;

    public ListInputReader(String filePath) {
        this.filePath = filePath;
    }

    public Pair<List<Integer>, List<Integer>> readIntegerListsFromInputFile() {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.trim().split("\\s+");

                if (split.length != 2) {
                    throw new IllegalArgumentException("Invalid input format: each line must contain exactly two values.");
                }

                try {
                    firstList.add(Integer.parseInt(split[0]));
                    secondList.add(Integer.parseInt(split[1]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number format in input file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }

        if (firstList.isEmpty() || secondList.isEmpty()) {
            throw new IllegalArgumentException("Input file must not be empty.");
        }

        return new Pair<>(firstList, secondList);
    }
}
