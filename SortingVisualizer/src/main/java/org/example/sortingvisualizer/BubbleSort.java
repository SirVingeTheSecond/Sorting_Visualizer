package org.example.sortingvisualizer;

import org.example.sortingvisualizer.Interface.ISortUpdateListener;

public class BubbleSort extends SortingAlgorithmTemplate {
    public BubbleSort(ISortUpdateListener listener) {
        super(listener);
    }

    @Override
    protected void doSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    listener.onSwap(j, j + 1);
                }
                listener.onCompare(j, j + 1);
            }
        }
    }
}