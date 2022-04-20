package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javafx.event.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

import static com.example.sailerapplication.DBConnector.getConnection;

public class Members_ManagementControllerClass implements Initializable {

    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;

    @FXML
    private TableColumn<Socio, String> col_name;

    @FXML
    private TableColumn<Socio, String> col_surname;

    @FXML
    private Button add_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private Button update_btn;

    @FXML
    private TextField name_textfield;

    @FXML
    private TextField surname_textfield;

    @FXML
    private TextField Address_textfield;

    @FXML
    private TextField fiscalcode_textfield;



    @FXML
    private TableView<Socio> table;

    ObservableList<Socio> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = null;

        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user");
            while(rs.next()) {
                oblist.add(new Socio(rs.getString("name"), rs.getString("surname") , rs.getString("fiscal_code") , rs.getString("address")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));

        table.setItems(oblist);

    }


    /**
     * CRUD OPERATION ON CLUB MEMBERS FROM ADMIN(Personale Circolo) DASHBOARD.
     * Add,Update and Delete functions synced with buttons in the GUI.
     */


    PreparedStatement pst = null;
    ResultSet rs = null;

    public void add_socio_function(ActionEvent e){
        try {
            String sql =    "INSERT INTO user"
                            +"(name, surname, address, fiscal_code)"
                            + "VALUES (?,?,?,?)";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,name_textfield.getText());
            pst.setString(2,surname_textfield.getText());
            pst.setString(3,Address_textfield.getText());
            pst.setString(4,fiscalcode_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Inserted successfully(Restart the app \nto display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , ex);
        }
    }

    public void Delete_Socio_BYNAME(ActionEvent e){
        try {
            String sql =    "DELETE FROM `user` WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,name_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Deleted successfully(Restart the app \nto display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , ex);
        }
    }

    public void Update_Socio_function(ActionEvent e){
        try {
            String sql = "UPDATE user SET name=?,surname=?,address=?,fiscal_code=? WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,name_textfield.getText());
            pst.setString(2,surname_textfield.getText());
            pst.setString(3,Address_textfield.getText());
            pst.setString(4,fiscalcode_textfield.getText());
            pst.setString(5,name_textfield.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Updated successfully(Restart the app \nto see the new changes)");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , ex);
        }

    }

}



