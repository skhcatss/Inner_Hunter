module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires commons.csv;
    opens com.example.demo to javafx.fxml;

    exports com.example.demo;
}