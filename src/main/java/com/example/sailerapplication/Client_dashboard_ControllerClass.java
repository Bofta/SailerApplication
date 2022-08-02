package com.example.sailerapplication;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client_dashboard_ControllerClass implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private Label exit;

    @FXML
    private Label logged_user;

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location , ResourceBundle resources) {
        try {
            URL url = new File("src/main/resources/com/example/sailerapplication/Client_dashboardHomePage.fxml").toURI().toURL();
            Parent fxml = FXMLLoader.load(url);
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex){
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE , null , ex);
        }
    }

    public void client_homepage(ActionEvent actionEvent) throws IOException{
        URL url = new File("src/main/resources/com/example/sailerapplication/Client_dashboardHomePage.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Property_management(ActionEvent actionEvent) throws IOException{
        URL url = new File("src/main/resources/com/example/sailerapplication/BoatAndChallenges_Client.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Clubfees_FXMLFILE_LOADER_FUNCTION(ActionEvent actionEvent) throws IOException{
        URL url = new File("src/main/resources/com/example/sailerapplication/Clubfees.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }




    public void userlogout(ActionEvent event ) throws IOException {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You're about to logout!");
            alert.setContentText("Do you want to save before exiting?");

            if (alert.showAndWait().get() == ButtonType.OK){
                SailerApplicaton m = new SailerApplicaton();
                m.changeScene("Gui.fxml");
                System.out.println("You successfully logged out");
            }
    }
}



