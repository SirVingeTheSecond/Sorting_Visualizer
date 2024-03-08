package org.example.sortingvisualizer;

import org.example.sortingvisualizer.Interface.ISortUpdateListener;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;
import org.example.sortingvisualizer.Interface.SortingAlgorithmSupplier;
import org.example.sortingvisualizer.SortingAlgorithms.BubbleSort;
import org.example.sortingvisualizer.Utility.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingAlgorithmFactory {
    private static Map<String, SortingAlgorithmSupplier> algorithms = new HashMap<>();

    // When the class is loaded into memory
    static {
        algorithms.put("Bubble Sort", (listener, sorter) -> new BubbleSort(listener, sorter));
        // Add other algorithms similarly
    }

    public static ISortingAlgorithm createAlgorithm(String algorithmName, ISortUpdateListener listener, Sorter sorter) {
        SortingAlgorithmSupplier algorithmSupplier = algorithms.get(algorithmName);
        if (algorithmSupplier == null) {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithmName);
        }
        return algorithmSupplier.get(listener, sorter);
    }

    public static List<String> getAvailableAlgorithms() {
        return new ArrayList<>(algorithms.keySet());
    }
}

