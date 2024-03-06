package org.example.sortingvisualizer;

import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class Sorter {
    private int[] data;
    private BarChart<String, Integer> barChart;
    private ISortingAlgorithm sortingAlgorithm;

    public Sorter(BarChart<String, Integer> barChart, int[] data, ISortingAlgorithm sortingAlgorithm) {
        this.barChart = barChart;
        this.data = data;
        this.sortingAlgorithm = sortingAlgorithm;
        drawChart();
    }

    public void sort() {
        new Thread(() -> {
            sortingAlgorithm.sort(data);
            drawChart();
        }).start();
    }

    private void drawChart() {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(data[i]), data[i]));
        }
        Platform.runLater(() -> barChart.getData().add(series));
    }
}

