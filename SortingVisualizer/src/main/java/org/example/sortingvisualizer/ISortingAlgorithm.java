package org.example.sortingvisualizer;

import javafx.concurrent.Task;

public interface ISortingAlgorithm {
    Task<Void> sort(int[] array);
}
