package com.example.sailerapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the main class and the entry-point of the application , executing this class will permits the launch of the app GUI
 *
 * @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 * @author      wajdi.lajdal <wajdi.lajdal@studenti.unipr.it>
 */

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
        exec_crud_ops.POST();
        exec_crud_ops.GET();

        Scene root = new Scene(fxmlLoader.load(),800 ,600);

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