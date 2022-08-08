package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


import static com.example.sailerapplication.DBConnector.getConnection;


public class BoatsAndChallenges_ClientControllerClass implements Initializable {

    @FXML
    private TableView<Socio> table;

    @FXML
    private TableColumn<?, ?> col_boat_owner;

    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;


    @FXML
    private TableColumn<Socio, String> col_sname;

    @FXML
    private TableColumn<Socio, String> col_membership_status;

    @FXML
    private TableColumn<Socio, Integer> col_CCBalance;

    @FXML
    private TableColumn<Socio, String> col_surname;

    @FXML
    private TableColumn<Boat, Integer> col_boat_length;

    @FXML
    private TableColumn<Boat, String> col_Status_boat_client;

    @FXML
    private TextField boat_ID_textfield;

    @FXML
    private TextField username_boats_textfield;

    @FXML
    private TableColumn<Boat, Integer> col_ID_boat;

    @FXML
    private TextField boat_name_textfield;

    @FXML
    private TableColumn<Boat, String> col_name_boat;

    @FXML
    private TableView<Boat> table1;



    ObservableList<Boat> oblist1 = FXCollections.observableArrayList();


    ObservableList<Socio> oblist4 = FXCollections.observableArrayList();


    Database_CRUD_Operations dbo = new Database_CRUD_Operations();


    /**
     *  BoatsAndChallenges_Admin is in charge of Boats and Challenges(Activities) and the B&C section in the application(Gui) in the admin interface.
     *  Main functions are adding boats (Own/Diwosn) boat and signing up to challenges or unsubscribing from them and also to pay parking fees to the equivalent boat.
     *
     *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
     *  @author      wajdi.lajdal <wajdi.lajdal@studenti.unipr.it>
     */



    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = dbo.getConnection();

        try {
            ResultSet rs1 = con.createStatement().executeQuery("SELECT * from boat");
            while (rs1.next()) {
                oblist1.add(new Boat(rs1.getInt("id"), rs1.getString("name"), rs1.getString("Status") , rs1.getString("owner") , rs1.getInt("length") , rs1.getString("owner_name")));
            }
        } catch (
                SQLException e) {
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


        col_ID_boat.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name_boat.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Status_boat_client.setCellValueFactory(new PropertyValueFactory<>("Status"));
        col_boat_owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        col_boat_length.setCellValueFactory(new PropertyValueFactory<>("length"));
        col_boat_owner.setCellValueFactory(new PropertyValueFactory<>("owner_name"));

        col_sname.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));
        col_CCBalance.setCellValueFactory(new PropertyValueFactory<>("CCBalance"));
        col_membership_status.setCellValueFactory(new PropertyValueFactory<>("Membership_status"));



        table1.setItems(oblist1);
        table.setItems(oblist4);

    }

    PreparedStatement pst = null;
    PreparedStatement pst1 = null;


    /**
     * Function that add a boat as a socio property
     * @param event
     * @throws IOException
     * @throws SQLException
     */


      public void own_Boat(ActionEvent event) throws IOException, SQLException {

          Connection con = getConnection();

          PreparedStatement strUpdate = con.prepareStatement("UPDATE boat b , user u "
                  + " SET b.owner = u.fiscal_code,"
                  + " b.owner_name = u.name"
                  + " WHERE b.Status= 'AVAILABLE'"
                  + " AND u.name='" + username_boats_textfield.getText()
                  + "' AND b.id=" + boat_ID_textfield.getText());

          System.out.println("The SQL statement is: " + strUpdate + "\n");
          strUpdate.executeUpdate();
          JOptionPane.showMessageDialog(null, "Boat_ID : " + boat_ID_textfield.getText() + " Has been added to your ownership\nCongratulations\nRefresh the page clicking on B&C button to display changes");
        }


    /**
     * Function that remove a boat from a socio property
     * @param event
     * @throws IOException
     * @throws SQLException
     */

    public void disown_Boat(ActionEvent event) throws IOException, SQLException {
        Connection con = getConnection();

        PreparedStatement strUpdate = con.prepareStatement("UPDATE boat set owner=NULL where name=" + "'" + boat_name_textfield.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Boat " + boat_name_textfield.getText() + " Has been removed from your membership\nRefresh the page clicking on B&C button to display changes");
    }

    public void pay_Parking_fees(ActionEvent event) throws IOException, SQLException {

        Connection con = getConnection();

        PreparedStatement strUpdate = con.prepareStatement("UPDATE user u, boat b set u.CCBalance= u.CCBalance-(b.length*50) where u.name=" + "'" + username_boats_textfield.getText()
                + "' AND b.id=" + boat_ID_textfield.getText());

        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        JOptionPane.showMessageDialog(null, "Socio " + username_boats_textfield.getText() + " Has payed his boat parking fees depending on the length of the boat\nRefresh the page clicking on club fees section button to display changes");

    }
}












