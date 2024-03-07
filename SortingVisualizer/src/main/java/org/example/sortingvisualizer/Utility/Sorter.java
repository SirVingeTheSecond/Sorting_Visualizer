package org.example.sortingvisualizer.Utility;

import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.concurrent.Task;
import org.example.sortingvisualizer.Interface.ISortingAlgorithm;

public class Sorter {
    private BarChart<String, Number> barChart;
    private ISortingAlgorithm sortingAlgorithm;

    public Sorter(BarChart<String, Number> barChart, ISortingAlgorithm sortingAlgorithm) {
        this.barChart = barChart;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public Task<Void> sort(int[] data) {
        Task<Void> sortTask = sortingAlgorithm.sort(data);
        sortTask.setOnSucceeded(e -> Platform.runLater(() -> updateUIAfterSort(data)));
        new Thread(sortTask).start(); // Start the task on a new thread
        return sortTask;
    }

    private void updateUIAfterSort(int[] data) {
        drawChart(data);
    }

    private void drawChart(int[] data) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), data[i]));
        }
        Platform.runLater(() -> {
            barChart.getData().clear();
            barChart.getData().add(series);
        });
    }
}

