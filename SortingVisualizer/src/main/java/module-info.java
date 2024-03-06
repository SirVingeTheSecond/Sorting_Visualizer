module org.example.sortingvisualizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sortingvisualizer to javafx.fxml;
    exports org.example.sortingvisualizer;
}