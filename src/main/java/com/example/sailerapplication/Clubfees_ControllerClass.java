package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

import static com.example.sailerapplication.DBConnector.getConnection;

public class Clubfees_ControllerClass implements Initializable {

    @FXML
    private TableView<Socio> table;

    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;

    @FXML
    private TableColumn<Activity, Integer> col_participants;

    @FXML
    private TableColumn<Socio, String> col_sname;

    @FXML
    private TableColumn<Socio, String> col_membership_status;


    @FXML
    private TableColumn<Socio, Integer> col_CCBalance;

    @FXML
    private TableColumn<Socio, String> col_surname;

    @FXML
    private TableView<Activity> Challenge_table;

    @FXML
    private TableColumn<Activity, String> col_challenge_clubfees;


    @FXML
    private TableColumn<Activity, Integer> col_prize_clubfees;

    @FXML
    private TextField name_textfield;

    @FXML
    private TextField email_field;


    ObservableList<Activity> oblist3 = FXCollections.observableArrayList();
    ObservableList<Socio> oblist4 = FXCollections.observableArrayList();
    private Object e;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = null;
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs5 = con.createStatement().executeQuery("SELECT * from challenges");
            while (rs5.next()) {
                oblist3.add(new Activity(rs5.getString(1), rs5.getInt(2), rs5.getInt(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user");
            while (rs.next()) {
                oblist4.add(new Socio(rs.getString("name"), rs.getString("surname"), rs.getString("username"), rs.getString("password"), rs.getString("fiscal_code"), rs.getString("address"), rs.getInt("CCBalance"), rs.getString("membership_status")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_sname.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));
        col_CCBalance.setCellValueFactory(new PropertyValueFactory<>("CCBalance"));
        col_membership_status.setCellValueFactory(new PropertyValueFactory<>("Membership_status"));


        col_prize_clubfees.setCellValueFactory(new PropertyValueFactory<>("prize"));
        col_challenge_clubfees.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_participants.setCellValueFactory(new PropertyValueFactory<>("participants"));

        Challenge_table.setItems(oblist3);
        table.setItems(oblist4);

    }


    public void check_Membership_Status(ActionEvent e) throws SQLException, IOException {

        Connection con = getConnection();
        PreparedStatement strSelect = con.prepareStatement("SELECT membership_status FROM user where name=" + "'" + name_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strSelect + "\n");
        ResultSet rset = strSelect.executeQuery();

        while (rset.next()) {
            String membership_status = rset.getString("membership_status");
            System.out.println("rset: " + rset + "\n" + "membership status : " + membership_status);
            String active = "active";
            String inactive = "inactive";
            if (membership_status.equals(active)) {
                JOptionPane.showMessageDialog(null, "Client " + name_textfield.getText() + " membership is " + membership_status);
            } else if (membership_status.equals(inactive)) {
                JOptionPane.showMessageDialog(null, "Client " + name_textfield.getText() + " membership is inactive\nYou will be redirected to payment window");
                Alert PayingMembership = new Alert(Alert.AlertType.CONFIRMATION);
                PayingMembership.setHeaderText("Membership payment");
                PayingMembership.setContentText("Proceed with membership payment?");
                if (PayingMembership.showAndWait().get() == ButtonType.OK) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PaymentSystem.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Membership payment window");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }


            }
        }
    }

    public void pay_Parking_fees(ActionEvent event) throws IOException, SQLException {

        Connection con = getConnection();

        PreparedStatement strUpdate = con.prepareStatement("UPDATE user set CCBalance= CCBalance-1000 where name=" + "'" + name_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Socio " + name_textfield.getText() + " Has payed 1000€ as parking fees for his boats\nRefresh the page clicking on club fees section button to display changes");
    }





}



