package com.example.sailerapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SailerApplicaton extends Application {

    private static Stage stg;
    double x , y;
    @Override
    public void start(Stage primaryStage) throws IOException {

        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(SailerApplicaton.class.getResource("Gui.fxml"));

        Database_CRUD_Operations exec_crud_ops = new Database_CRUD_Operations();

        exec_crud_ops.createTables();
        exec_crud_ops.post();
        exec_crud_ops.get();

        Scene root = new Scene(fxmlLoader.load(),700 ,480);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();

        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getSceneX() - x);
            primaryStage.setY(event.getSceneY() - y);
        });

        stg.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            logout(stg);
        });



        primaryStage.setTitle("SailerApplication");
        primaryStage.setScene(root);
        primaryStage.show();
    }

    private void logout(Stage stg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to exit the app!");
        

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out");
            stg.close();
        }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }



    public static void main(String[] args) {
        launch();
    }
}