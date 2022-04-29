package com.example.sailerapplication;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


public class Admin_dashboard_ControllerClass implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private Label exit;

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location , ResourceBundle resources) {
        try {
            URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\resources\\com\\example\\sailerapplication\\Admin_dashboardHomePage.fxml").toURI().toURL();
            Parent fxml = FXMLLoader.load(url);
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex){
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE , null , ex);
        }
    }

    public void home(javafx.event.ActionEvent actionEvent) throws IOException{
        URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\resources\\com\\example\\sailerapplication\\Admin_dashboardHomePage.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Property_management(javafx.event.ActionEvent actionEvent) throws IOException{
        URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\resources\\com\\example\\sailerapplication\\Members_Management.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Clubfees_FXMLFILE_LOADER_FUNCTION(javafx.event.ActionEvent actionEvent) throws IOException{
        URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\resources\\com\\example\\sailerapplication\\Clubfees.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }



    public void Notifications(javafx.event.ActionEvent actionEvent) throws IOException{
        URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\resources\\com\\example\\sailerapplication\\Notifications.fxml").toURI().toURL();
        Parent fxml = FXMLLoader.load(url);
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void BoatsAndChallenges(javafx.event.ActionEvent actionEvent) throws IOException{
        URL url = new File("C:\\Users\\bbelh\\IdeaProjects\\SailerApplication\\src\\main\\java\\com\\example\\sailerapplication\\BoatsAndChallenges.fxml").toURI().toURL();
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



