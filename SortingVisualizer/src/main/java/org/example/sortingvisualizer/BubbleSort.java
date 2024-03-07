package org.example.sortingvisualizer;

import javafx.concurrent.Task;

public class BubbleSort implements ISortingAlgorithm {
    @Override
    public Task<Void> sort(int[] array) {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                            updateMessage("Swapped " + array[j] + " with " + array[j + 1]);
                            Thread.sleep(10);
                        }
                    }
                }
                return null;
            }
        };
    }
}
