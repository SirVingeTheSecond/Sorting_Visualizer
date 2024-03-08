package org.example.sortingvisualizer;

import org.example.sortingvisualizer.Interface.ISortUpdateListener;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;
import org.example.sortingvisualizer.Interface.ISortingAlgorithmSupplier;
import org.example.sortingvisualizer.SortingAlgorithms.*;
import org.example.sortingvisualizer.Utility.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingAlgorithmFactory {
    private static Map<String, ISortingAlgorithmSupplier> algorithms = new HashMap<>();

    // Executed when the class is loaded into memory
    static {
        algorithms.put("Bubble Sort", (listener, sorter) -> new BubbleSort(listener, sorter));
        algorithms.put("Insertion Sort", (listener, sorter) -> new InsertionSort(listener, sorter));
        algorithms.put("Merge Sort", (listener, sorter) -> new MergeSort(listener, sorter));
        algorithms.put("Qucik Sort", (listener, sorter) -> new QuickSort(listener, sorter));
        algorithms.put("Radix Sort", (listener, sorter) -> new RadixSort(listener, sorter));
        // New algorithms goes here
    }

    public static ISortingAlgorithm createAlgorithm(String algorithmName, ISortUpdateListener listener, Sorter sorter) {
        ISortingAlgorithmSupplier algorithmSupplier = algorithms.get(algorithmName);
        if (algorithmSupplier == null) {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithmName);
        }
        return algorithmSupplier.get(listener, sorter);
    }

    public static List<String> getAvailableAlgorithms() {
        return new ArrayList<>(algorithms.keySet());
    }
}

