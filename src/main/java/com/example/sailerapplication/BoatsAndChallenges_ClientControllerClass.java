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
    private TextField boatname_textfield;

    @FXML
    private TextField challenge_textfield;

    @FXML
    private TableColumn<Boat, String> col_boat_owner;

    @FXML
    private TableColumn<Boat, String> col_Status_boat_client;


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
    private Object Integer;


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


    // FINESTRA POPUP PAGAMENTO

      public void Own_Boat(ActionEvent event) throws IOException {
             Alert boatByingNotifications = new Alert(Alert.AlertType.CONFIRMATION);
             boatByingNotifications.setHeaderText("Boat Payment");
             boatByingNotifications.setContentText("Proceed with payment?");
              if (boatByingNotifications.showAndWait().get() == ButtonType.OK){
                  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PaymentSystem.fxml"));
                  Parent root1 = (Parent) fxmlLoader.load();
                  Stage stage = new Stage();
                  stage.setTitle("Payment System");
                  stage.setScene(new Scene(root1));
                  stage.show();

             }
          }


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
     * SignUp_to_challenge event handler that signup the user to a challenge.
     *
     * @param e
     */

    public void SignUp_to_challenge_function(ActionEvent e) {
        try {
            Connection con = getConnection();
            String sql0 = "select participants from challenges" +
                    "where name =?";
            pst = con.prepareStatement(sql0);
            pst.setString(1, challenge_textfield.getText());

            String sql = "INSERT INTO challenges SET participants=?"
                    + "where name =?";
            String result = sql0;
            pst1 = con.prepareStatement(sql);
            pst.setString(2, result + 1);
            pst.setString(3, challenge_textfield.getText());
            pst.executeUpdate();
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Socio subscribed successfully to challenge(Click on B&C section button to refresh the page\nand display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}












