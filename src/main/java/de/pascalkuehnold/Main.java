package de.pascalkuehnold;

import de.pascalkuehnold.util.Calculator;
import de.pascalkuehnold.util.ListInputReader;
import de.pascalkuehnold.util.Pair;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListInputReader listInputReader = new ListInputReader("src/main/resources/lists.txt");
        try {
            Pair<List<Integer>, List<Integer>> lists = listInputReader.readIntegerListsFromInputFile();

            List<Integer> sortedList = lists.first().stream().sorted().toList();
            List<Integer> sortedList2 = lists.second().stream().sorted().toList();

            int similarityScore = Calculator.calculateSimilarityScore(sortedList, sortedList2);
            System.out.println("The similarity score is: " + similarityScore);

            int distance = Calculator.calculateDistance(sortedList, sortedList2);
            System.out.println("The distance is: " + distance);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

