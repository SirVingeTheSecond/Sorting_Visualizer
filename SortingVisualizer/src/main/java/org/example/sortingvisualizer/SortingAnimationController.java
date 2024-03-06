package org.example.sortingvisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class SortingAnimationController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private Sorter sorter;

    public void initialize() {
        int[] data = new int[50];
        for (int i = 0; i < 50; i++) {
            data[i] = i + 1;
        }
        shuffleArray(data);
        sorter = new Sorter(barChart, data, new BubbleSort());
    }

    @FXML
    private void sort() {
        sorter.sort();
    }

    // Helper method to shuffle the array
    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
