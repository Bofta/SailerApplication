package com.example.sailerapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * THIS CLASS CONTAINS THE LOGIN CONTROLLER which permits to verify the credentials of the persons that wants to connect
 *  if it connects with admin credentials he will be redirected to the admin dashboard Panel
 *  else if he connects with users credentials that already exists he will be redirected to the user(Socio) dashboard Panel
 *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 *  @author      wajdi.lajdal <wajdi.lajdal@studenti.unipr.it>
 *
 */

public class LoginController {

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

        String verifyLogin_ADMIN = "SELECT COUNT(1) FROM admin WHERE username='" + usernameTextField.getText() + "' and PASSWORD='" + passwordPasswordField.getText() +  "'";

        /**
         * ADMIN AND USER LOGIN VERIFICATION
         *
         */

        try {
            SailerApplicaton SailerScene = new SailerApplicaton();
            Statement statement = connectDB.createStatement();
            ResultSet queryResult1 = statement.executeQuery(verifyLogin_ADMIN);


            while(queryResult1.next()){
                if (queryResult1.getInt(1)==1 ) {
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

        String verifyLogin_USER = "SELECT COUNT(1) FROM user WHERE username='" + usernameTextField.getText() + "' and PASSWORD='" + passwordPasswordField.getText() +  "'";


        try {
            SailerApplicaton SailerScene = new SailerApplicaton();
            Statement statement = connectDB.createStatement();
            ResultSet queryResult2 = statement.executeQuery(verifyLogin_USER);


            while(queryResult2.next()){
                if (queryResult2.getInt(1)==1 ) {
                    LoginButtonMessageLABEL.setText("Successful login");
                    SailerScene.changeScene("Client_dashboard.fxml");
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
