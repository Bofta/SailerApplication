module com.example.sailerapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sailerapplication to javafx.fxml;
    exports com.example.sailerapplication;
}