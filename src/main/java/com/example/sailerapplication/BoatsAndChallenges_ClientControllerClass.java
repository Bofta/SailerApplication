package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



import static com.example.sailerapplication.DBConnector.getConnection;


public class BoatsAndChallenges_ClientControllerClass implements Initializable {


    @FXML
    private TextField prize_textfield;

    @FXML
    private Button add_boat_btn;

    @FXML
    private Button add_challenge_btn;

    @FXML
    private TextField boatid_textfield;

    @FXML
    private TextField boatname_textfield;

    @FXML
    private TextField challenge_textfield;

    @FXML
    private Button delete_boat_btn;

    @FXML
    private TableColumn<Boat, String> col_Status_boat_client;


    @FXML
    private TableColumn<Boat, Integer> col_ID_boat;

    @FXML
    private TableColumn<Boat, String> col_name_boat;


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
                oblist1.add(new Boat(rs1.getInt("id"), rs1.getString("name"), rs1.getString("Status")));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs2 = con.createStatement().executeQuery("SELECT * from challenges");
            while (rs2.next()) {
                oblist2.add(new Activity(rs2.getString("name"), rs2.getInt(2)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        col_ID_boat.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name_boat.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Status_boat_client.setCellValueFactory(new PropertyValueFactory<>("Status"));

        col_prize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table1.setItems(oblist1);
        table2.setItems(oblist2);


    }

    PreparedStatement pst = null;


    /**
     * Add boat button event handler that adds a boat with the user input informations into the database using the app.
     *
     * @param e
     */

    public void buy_Boat(ActionEvent e) {
        try {
            String sql = "INSERT INTO boat"
                    + "(id, name)"
                    + "VALUES (?,?)";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, boatid_textfield.getText());
            pst.setString(2, boatname_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted successfully(Click on boats and challenges sections button to refresh the page\nand display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Update boat button event handler that adds a boat with the user input informations into the database using the app.
     *
     * @param e
     */




    /**
     * Delete boat button event handler that adds a boat with the user input informations from the database using the app.
     *
     * @param e
     */

    public void Delete_boat_BYNAME(ActionEvent e){
        try {
            String sql =    "DELETE FROM boat WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, boatname_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Deleted successfully(Click on boats and challenges sections button to refresh the page\nto display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , ex);
        }
    }


    /**
     * Add challenge button event handler that adds a challenge with the user input information into the database using the app.
     *
     * @param e
     */


    public void add_challenge_function(ActionEvent e) {
        try {
            String sql = "INSERT INTO challenges"
                    + "(name, prize)"
                    + "VALUES (?,?)";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, challenge_textfield.getText());
            pst.setString(2, prize_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted successfully(Click on boats and challenges sections button to refresh the page\nto display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Update challenge button event handler that adds a challenge with the user input information into the database using the app.
     *
     * @param e
     */


    /**
     * Remove boat button event handler that remove a challenge with the user input information from the database using the app.
     *
     * @param e
     */

    public void Delete_challenge_BYNAME(ActionEvent e){
        try {
            String sql =    "DELETE FROM challenges WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, challenge_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Deleted successfully(Click on boats and challenges sections button to refresh the page\nto display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , ex);
        }
    }

    /**
     * method that permits the owner to add a boat to his property*
     *
     */



}












