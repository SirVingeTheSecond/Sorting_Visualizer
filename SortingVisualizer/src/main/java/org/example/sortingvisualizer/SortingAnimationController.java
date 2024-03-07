package org.example.sortingvisualizer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import org.example.sortingvisualizer.Interface.ISortUpdateListener;
import org.example.sortingvisualizer.Utility.Sorter;


public class SortingAnimationController implements ISortUpdateListener {

    @FXML
    private BarChart<String, Number> barChart;

    private int[] data;
    private Sorter sorter;

    @FXML
    public void initialize() {
        data = createShuffledArray(50);
        sorter = new Sorter(new BubbleSort(this));
        drawChart();
    }

    @FXML
    public void handleSortButtonAction() {
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

    private void updateBarChart(int index1, int index2) {
        XYChart.Series<String, Number> series = barChart.getData().get(0);
        XYChart.Data<String, Number> data1 = series.getData().get(index1);
        XYChart.Data<String, Number> data2 = series.getData().get(index2);
        Number temp = data1.getYValue();
        data1.setYValue(data2.getYValue());
        data2.setYValue(temp);
    }

    @Override
    public void onSwap(int index1, int index2) {
        Platform.runLater(() -> {
            updateBarChart(index1, index2);
        });
    }

    @Override
    public void onCompare(int index1, int index2) {
        // Optionally update the UI to reflect comparisons
    }
}
