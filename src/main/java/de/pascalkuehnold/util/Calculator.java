package de.pascalkuehnold.util;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Calculator {
    public static int calculateDistance(List<Integer> firstList, List<Integer> secondList) {
        if (firstList.size() != secondList.size()) {
            throw new IllegalArgumentException("Lists must have the same length.");
        }

        return firstList.stream()
                .mapToInt(i -> Math.abs(i - secondList.get(firstList.indexOf(i))))
                .sum();
    }

    public static int calculateSimilarityScore(List<Integer> sortedList, List<Integer> sortedList2) {
        if (sortedList.size() != sortedList2.size()) {
            throw new IllegalArgumentException("Lists must have the same length.");
        }

        // Create a frequency map for elements in list2.
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : sortedList2) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int similarityScore = 0;

        // Calculate the similarity score based on the frequency in list2.
        for (Integer num : sortedList) {
            int countInList2 = frequencyMap.getOrDefault(num, 0);
            similarityScore += num * countInList2;
        }

        return similarityScore;
    }
}