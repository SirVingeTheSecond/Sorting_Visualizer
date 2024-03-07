package org.example.sortingvisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class SortingAnimationController {

    @FXML
    private BarChart<String, Number> barChart;

    private int[] data;
    private Sorter sorter;

    @FXML
    public void initialize() {
        data = createShuffledArray(50);
        sorter = new Sorter(barChart, new BubbleSort());
        drawChart();
    }

    @FXML
    private void handleSortButtonAction() {
        sorter.sort(data);
    }

    private int[] createShuffledArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        // Shuffle the array
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    private void drawChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), data[i]));
        }
        barChart.getData().clear();
        barChart.getData().add(series);
    }
}
