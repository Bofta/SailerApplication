package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;

import static com.example.sailerapplication.DBConnector.getConnection;

public class Clubfees_ControllerClass implements Initializable{

    @FXML
    private TableView<Socio> table;

    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;

    @FXML
    private TableColumn<Socio, String> col_sname;

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



    ObservableList<Activity> oblist3 = FXCollections.observableArrayList();
    ObservableList<Socio> oblist4 = FXCollections.observableArrayList();



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
                oblist3.add(new Activity(rs5.getString(1), rs5.getInt(2)));

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
                oblist4.add(new Socio(rs.getString("name"), rs.getString("surname"), rs.getString("fiscal_code"), rs.getString("address"), rs.getInt("CCBalance")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_sname.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));
        col_CCBalance.setCellValueFactory(new PropertyValueFactory<>("CCBalance"));



        col_prize_clubfees.setCellValueFactory(new PropertyValueFactory<>("prize"));
        col_challenge_clubfees.setCellValueFactory(new PropertyValueFactory<>("name"));


        Challenge_table.setItems(oblist3);
        table.setItems(oblist4);



    }
}
