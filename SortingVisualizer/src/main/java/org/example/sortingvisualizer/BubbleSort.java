package org.example.sortingvisualizer;

public class BubbleSort extends SortingAlgorithmTemplate {
    @Override
    protected void doSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // Pause for visualization
                    sleepForVisualization(10);
                }
            }
        }
    }
}
