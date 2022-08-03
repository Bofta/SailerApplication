package com.example.sailerapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Scanner;


public class Boat_ownership_controllerClass {

    @FXML
    private Button confirm_btn;

    @FXML
    private Button cancel_btn;

    @FXML
    private TextField creditcardnumber_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField exp_date_field;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField fullname_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField securitycode_field;

    @FXML
    private TextField username_field;


    @FXML
    private void VerifyInput_NOT_EMPTY(){
        if (username_field.getText().isEmpty() == false || lastname_field.getText().isEmpty() == false
                ||  fullname_field.getText().isEmpty()== false || firstname_field.getText().isEmpty() == true
                 || email_field.getText().isEmpty() == false
                );
        JOptionPane.showMessageDialog(null, "A empty textfiled has been detected\nPlease fill with correct information");
        }


    @FXML
    private void VerifyInput(){
        Scanner stdin = new Scanner(System.in);
        if ( creditcardnumber_field.getText().isEmpty()== false ||  exp_date_field.getText().isEmpty()== false || securitycode_field.getText().isEmpty()== false){
            JOptionPane.showMessageDialog(null, "Please enter a valid input");
        }
    }

    @FXML
    private void ConfirmButtonAction(){
        VerifyInput();

        Stage stage = (Stage) confirm_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) cancel_btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }




}
