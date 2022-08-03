package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



import static com.example.sailerapplication.DBConnector.getConnection;


public class BoatsAndChallenges_ClientControllerClass implements Initializable {

    @FXML
    private TextField username_challenges_textfield;

    @FXML
    private TextField name_textfield;

    @FXML
    private TextField boatname_textfield;

    @FXML
    private TextField challenge_textfield;

    @FXML
    private TableColumn<Boat, String> col_boat_owner;

    @FXML
    private TableColumn<Boat, String> col_Status_boat_client;

    @FXML
    private TextField username_boats_textfield;

    @FXML
    private TableColumn<Boat, Integer> col_ID_boat;

    @FXML
    private TableColumn<Boat, String> col_name_boat;

    @FXML
    private TableColumn<Activity, Integer> col_participants;


    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<Activity, Integer> col_prize;

    @FXML
    private TableView<Boat> table1;

    @FXML
    private TableView<Activity> table2;

    ObservableList<Boat> oblist1 = FXCollections.observableArrayList();
    ObservableList<Activity> oblist2 = FXCollections.observableArrayList();

    Database_CRUD_Operations dbo = new Database_CRUD_Operations();


    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = dbo.getConnection();

        try {
            ResultSet rs1 = con.createStatement().executeQuery("SELECT * from boat");
            while (rs1.next()) {
                oblist1.add(new Boat(rs1.getInt("id"), rs1.getString("name"), rs1.getString("Status") , rs1.getString("owner")));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs2 = con.createStatement().executeQuery("SELECT * from challenges");
            while (rs2.next()) {
                oblist2.add(new Activity(rs2.getString("name"), rs2.getInt(2) , rs2.getInt(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        col_ID_boat.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name_boat.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Status_boat_client.setCellValueFactory(new PropertyValueFactory<>("Status"));
        col_boat_owner.setCellValueFactory(new PropertyValueFactory<>("owner"));

        col_prize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_participants.setCellValueFactory(new PropertyValueFactory<>("participants"));

        table1.setItems(oblist1);
        table2.setItems(oblist2);

    }

    PreparedStatement pst = null;
    PreparedStatement pst1 = null;


    /**
     * Function that add a boat as a socio Membership
     * @param event
     * @throws IOException
     * @throws SQLException
     */

      public void own_Boat(ActionEvent event) throws IOException, SQLException {

          Connection con = getConnection();

          PreparedStatement strUpdate = con.prepareStatement("UPDATE boat set owner=" + "'" + username_boats_textfield.getText() + "' where name=" + "'" + boatname_textfield.getText() + "'");
          System.out.println("The SQL statement is: " + strUpdate + "\n");
          strUpdate.executeUpdate();
          JOptionPane.showMessageDialog(null, "Boat " + boatname_textfield.getText() + " Has been added to your ownership\nCongratulations\nRefresh the page clicking on B&C button to display changes");
        }


    /**
     * Function that add a boat as a socio Membership
     * @param event
     * @throws IOException
     * @throws SQLException
     */

    public void disown_Boat(ActionEvent event) throws IOException, SQLException {

        Connection con = getConnection();

        PreparedStatement strUpdate = con.prepareStatement("UPDATE boat set owner=NULL where name=" + "'" + boatname_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Boat " + boatname_textfield.getText() + " Has been removed from your membership\nRefresh the page clicking on B&C button to display changes");
    }

    /**
     * SignUp_to_challenge event handler that signup the user to a challenge.
     *
     * @param e
     */

    public void SignUp_Socio_to_challenge_function(ActionEvent e) throws SQLException {

        Connection con = getConnection();
        PreparedStatement strUpdate = con.prepareStatement("UPDATE challenges set participants= participants + 1   where name=" + "'" + challenge_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Socio " + username_challenges_textfield.getText() + " Has been added to " + challenge_textfield + " as a new participant\nGood Luck in your next challenge\nRefresh the page clicking on B&C button to display changes");
    }

    public void unsubscribe_socio_from_challenge_function(ActionEvent e) throws SQLException {

        Connection con = getConnection();
        PreparedStatement strUpdate = con.prepareStatement("UPDATE challenges set participants= participants - 1   where name=" + "'" + challenge_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Socio " + username_challenges_textfield.getText() + " Has been removed from the specified challenge\nGood Luck in your next challenge\nRefresh the page clicking on B&C button to display changes");
    }





}












