package org.example.sortingvisualizer;

import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.concurrent.Task;

public class Sorter {
    private BarChart<String, Number> barChart;
    private ISortingAlgorithm sortingAlgorithm;

    public Sorter(BarChart<String, Number> barChart, ISortingAlgorithm sortingAlgorithm) {
        this.barChart = barChart;
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sort(int[] data) {
        Task<Void> sortTask = sortingAlgorithm.sort(data);
        sortTask.messageProperty().addListener((obs, oldMessage, newMessage) -> {
            Platform.runLater(() -> drawChart(data));
        });

        new Thread(sortTask).start();
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
