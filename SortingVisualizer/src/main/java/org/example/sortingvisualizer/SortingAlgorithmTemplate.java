package org.example.sortingvisualizer;

import javafx.concurrent.Task;
import org.example.sortingvisualizer.Interface.ISortUpdateListener;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;

public abstract class SortingAlgorithmTemplate implements ISortingAlgorithm {
    protected ISortUpdateListener listener;

    public SortingAlgorithmTemplate(ISortUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public Task<Void> sort(int[] array) {
        return new Task<Void>() {
            @Override
            protected Void call() {
                if (!validate(array)) {
                    updateMessage("Invalid array. Cannot perform sort.");
                    return null;
                }

                beforeSort(array);
                doSort(array);
                afterSort(array);
                return null;
            }

            private boolean validate(int[] array) {
                return array != null && array.length > 1;
            }
        };
    }

    protected void beforeSort(int[] array) {
        // Optional: Override in subclasses if needed
    }

    protected abstract void doSort(int[] array);

    protected void afterSort(int[] array) {
        // Optional: Override in subclasses if needed
    }

    protected void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

