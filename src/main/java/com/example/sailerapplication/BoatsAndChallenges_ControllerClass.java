package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;


public class BoatsAndChallenges_ControllerClass implements Initializable{

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
                oblist1.add(new Boat(rs1.getInt("id"), rs1.getString("bname")));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs2 = con.createStatement().executeQuery("SELECT * from challenges");
            while (rs2.next()) {
                oblist2.add(new Activity(rs2.getString("name"),rs2.getInt(2 )));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        col_ID_boat.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name_boat.setCellValueFactory(new PropertyValueFactory<>("mbname"));

        col_prize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table1.setItems(oblist1);
        table2.setItems(oblist2);



    }
}
