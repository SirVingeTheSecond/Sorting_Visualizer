//package org.example.sortingvisualizer.SortingAlgorithms;
//
//import org.example.sortingvisualizer.Interface.ISortUpdateListener;
//import org.example.sortingvisualizer.SortingAlgorithmTemplate;
//
//public class QuickSort extends SortingAlgorithmTemplate {
//    public QuickSort(ISortUpdateListener listener) {
//        super(listener);
//    }
//
//    @Override
//    protected void doSort(int[] array) {
//        quickSort(array, 0, array.length - 1);
//    }
//
//    private void quickSort(int[] array, int low, int high) {
//        if (low < high) {
//            int pivotIndex = partition(array, low, high);
//            quickSort(array, low, pivotIndex - 1);
//            quickSort(array, pivotIndex + 1, high);
//        }
//    }
//
//    private int partition(int[] array, int low, int high) {
//        int pivot = array[high];
//        int i = (low - 1);
//        for (int j = low; j < high; j++) {
//            if (array[j] < pivot) {
//                i++;
//                int tmp = array[i];
//                array[i] = array[j];
//                array[j] = tmp;
//                listener.onSwap(i, j);
//                sleep(10); // Set thread sleep time to modify animation
//            }
//        }
//        int tmp = array[i + 1];
//        array[i + 1] = array[high];
//        array[high] = tmp;
//        listener.onSwap(i + 1, high);
//        sleep(10); // Set thread sleep time to modify animation
//        return i + 1;
//    }
//}
