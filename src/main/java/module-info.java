module com.example.sailerapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;


    opens com.example.sailerapplication to javafx.fxml;
    exports com.example.sailerapplication;
}