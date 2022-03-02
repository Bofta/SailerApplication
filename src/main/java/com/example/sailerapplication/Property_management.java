package com.example.sailerapplication;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.*;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Property_management implements Initializable {


    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;

    @FXML
    private TableColumn<Socio, String> col_name;

    @FXML
    private TableColumn<Socio, String> col_password;

    @FXML
    private TableColumn<Socio, String> col_surname;

    @FXML
    private TableColumn<Socio, String> col_username;

    @FXML
    private TableColumn<Boat, Integer> col_ID_boat;

    @FXML
    private TableColumn<Boat, String> col_name_boat;

    @FXML
    private TableColumn<Activity, String> col_Competition;

    /**
     * Participants column -> naming used to bypass bug
     */
    @FXML
    private TableColumn<Activity, Integer> col_Competition1;

    /**
     * prize column -> naming used to bypass bug
     */
    @FXML
    private TableColumn<Activity, String> col_name1;

    @FXML
    private TableView<Socio> table;

    @FXML
    private TableView<Boat> table1;

    @FXML
    private TableView<Activity> table2;

    ObservableList<Socio> oblist = FXCollections.observableArrayList();
    ObservableList<Boat> oblist1 = FXCollections.observableArrayList();
    ObservableList<Activity> oblist2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user");
            while(rs.next()) {
                oblist.add(new Socio(rs.getString("name"), rs.getString("surname") , rs.getString("username"), rs.getString("password") ,rs.getString("fiscal_code") , rs.getString("address")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs1 = con.createStatement().executeQuery("SELECT id , bname from boat");
            while(rs1.next()){
                oblist1.add(new Boat(rs1.getInt("id"),rs1.getString("bname")));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs2 = con.createStatement().executeQuery("SELECT cname from challenges");
            while(rs2.next()){
                oblist2.add(new Activity(rs2.getString("cname")));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));


        col_ID_boat.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name_boat.setCellValueFactory(new PropertyValueFactory<>("mbname"));

        col_Competition.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.setItems(oblist);
        table1.setItems(oblist1);
        table2.setItems(oblist2);

    }
}
