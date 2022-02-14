package com.example.sailerapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogIn {

    @FXML
    private Button login_button;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private Label wronglogin;

    @FXML
    void userlogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        if(username.getText().toString().equals("root") && password.getText().toString().equals("root")) {
            wronglogin.setText("You have successfulyy logged in.");

            m.changeScene("afterLogin.fxml");
        }

        else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wronglogin.setText("Please enter your data");
        }

        else {
            wronglogin.setText("Wrong username or password");
        }
    }

}
