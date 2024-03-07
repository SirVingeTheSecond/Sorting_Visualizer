package org.example.sortingvisualizer;

import javafx.concurrent.Task;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;

public abstract class SortingAlgorithmTemplate implements ISortingAlgorithm {
    @Override
    public final Task<Void> sort(int[] array) {
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
                // General validation logic for the inputted array
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

    /**
     * Pauses the sorting thread for visualization purposes.
     * @param milliseconds The number of milliseconds to sleep.
     */
    protected void sleepForVisualization(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Restore the interrupted status
            Thread.currentThread().interrupt();
        }
    }
}

