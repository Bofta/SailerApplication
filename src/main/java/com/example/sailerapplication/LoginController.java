package com.example.sailerapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button login_button;

    @FXML
    private Label close;

    @FXML
    private TextField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label LoginButtonMessageLABEL;

    @FXML
    void userlogin(ActionEvent event) throws IOException {
        checkLogin();
    }



    private void checkLogin() throws IOException {
        SailerApplicaton m = new SailerApplicaton();

        if (usernameTextField.getText().isEmpty() == false && passwordPasswordField.getText().isEmpty()== false) {
            validateLogin();
        }
        else {
            LoginButtonMessageLABEL.setText("Please enter your data");
        }
    }

    public void validateLogin(){
        Database_CRUD_Operations connectNow = new Database_CRUD_Operations();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM admin WHERE username='" + usernameTextField.getText() + "' and PASSWORD='" + passwordPasswordField.getText() +  "'";

        try {
            SailerApplicaton SailerScene = new SailerApplicaton();
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1)==1 ) {
                    LoginButtonMessageLABEL.setText("Successful login");
                    SailerScene.changeScene("Admin_dashboard.fxml");
                } else {
                    LoginButtonMessageLABEL.setText("Invalid Credentials.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


}
