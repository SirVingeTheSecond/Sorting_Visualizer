package org.example.sortingvisualizer.Utility;

import javafx.concurrent.Task;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;

public class Sorter {
    private ISortingAlgorithm algorithm;

    public Sorter(ISortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void sort(int[] array) {
        Task<Void> sortTask = algorithm.sort(array);
        Thread sortThread = new Thread(sortTask);
        sortThread.setDaemon(true);
        sortThread.start();
    }
}