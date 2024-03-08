package org.example.sortingvisualizer.Interface;

import org.example.sortingvisualizer.Utility.Sorter;

public interface SortingAlgorithmSupplier {
    ISortingAlgorithm get(ISortUpdateListener listener, Sorter sorter);
}

