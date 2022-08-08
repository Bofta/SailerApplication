package com.example.sailerapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.*;
import javafx.event.*;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import static com.example.sailerapplication.DBConnector.getConnection;



public class Members_ManagementControllerClass implements Initializable {

    @FXML
    private TableColumn<Socio, String> col_address;

    @FXML
    private TableColumn<Socio, String> col_fiscal_code;

    @FXML
    private TableColumn<Socio, String> col_sname;

    @FXML
    private TableColumn<Socio, String> col_membership;

    @FXML
    private TableColumn<Socio, Integer> col_CCBalance;

    @FXML
    private TableColumn<Socio, String> col_surname;

    @FXML
    private TableColumn<Socio, String> col_username;

    @FXML
    private TableColumn<Socio, String> col_password;



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
    private TextField CCBalance_textfield;

    @FXML
    private TextField Password_textfield;

    @FXML
    private TextField Username_txtfield;

    @FXML
    private TableView<Socio> table;

    ObservableList<Socio> oblist = FXCollections.observableArrayList();



    /**
     *  This class containts the functions and is related to the gui to control and verify members informations by th admins
     *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
     *  @author      wajdi.lajdal <wajdi.lajdal@studenti.unipr.it>
     *
     */


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
            while (rs.next()) {
                oblist.add(new Socio(rs.getString("name"), rs.getString("surname"), rs.getString("username"), rs.getString("password"), rs.getString("fiscal_code"), rs.getString("address"), rs.getInt("CCBalance") , rs.getString("membership_status")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_sname.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_fiscal_code.setCellValueFactory(new PropertyValueFactory<>("fiscal_code"));
        col_CCBalance.setCellValueFactory(new PropertyValueFactory<>("CCBalance"));
        col_membership.setCellValueFactory(new PropertyValueFactory<>("Membership_status"));

        table.setItems(oblist);

    }


    /**
     * CRUD OPERATION ON CLUB MEMBERS FROM ADMIN(Personale Circolo) DASHBOARD.
     * Add,Update and Delete functions synced with buttons in the GUI.
     */


    PreparedStatement pst = null;

    public void add_socio_function(ActionEvent e) {
        try {
            String sql = "INSERT INTO user"
                    + "(name, surname, username , password , address, fiscal_code, CCBalance)"
                    + "VALUES (?,?,?,?,?,?,?)";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, name_textfield.getText());
            pst.setString(2, surname_textfield.getText());
            pst.setString(3, Username_txtfield.getText());
            pst.setString(4, Password_textfield.getText());
            pst.setString(5, Address_textfield.getText());
            pst.setString(6, fiscalcode_textfield.getText());
            if (CCBalance_textfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Error -> Check the credit card balance box it must not be empty , if you dont want to modify it just put in the same value");
            }
            pst.setInt(7, Integer.parseInt(CCBalance_textfield.getText()));
            pst.executeUpdate();
            table.refresh();
            JOptionPane.showMessageDialog(null, "Inserted successfully(Click on members sections button to refresh the page\nand display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void Delete_Socio_BYNAME(ActionEvent e) {
        try {
            String sql = "DELETE FROM `user` WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, name_textfield.getText());
            pst.executeUpdate();
            table.refresh();
            JOptionPane.showMessageDialog(null, "Deleted successfully(Click on members sections button to refresh the page \nand display the new changes)");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void Update_Socio_function(ActionEvent e) {
        try {
            String sql = "UPDATE user SET name=?,surname=?,username=?,password=?,address=?,fiscal_code=?,CCBalance=? WHERE name=?";
            Connection con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, name_textfield.getText());
            pst.setString(2, surname_textfield.getText());
            pst.setString(3, Username_txtfield.getText());
            pst.setString(4, Password_textfield.getText());
            pst.setString(5, Address_textfield.getText());
            pst.setString(6, fiscalcode_textfield.getText());
            if (CCBalance_textfield.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Error -> Check the credit card balance box it must not be empty , if you dont want to modify it just put in the same value");
            }
            pst.setInt(7, Integer.parseInt(CCBalance_textfield.getText()));

            pst.setString(8, name_textfield.getText());
            pst.executeUpdate();
            table.refresh();
            JOptionPane.showMessageDialog(null, "Updated successfully(Click on members sections button to refresh the page\nand see the new changes)");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void NotifyMembers_function(ActionEvent e) throws MessagingException, SQLException {
        sendMail();
        JOptionPane.showMessageDialog(null,"A notification has been sent to the mail");
    }


    public void sendMail() throws MessagingException, SQLException {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");

        String MyAccountEmail = "comeonapp@outlook.com";
        String password = "easypass123";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccountEmail, password);
            }
        });

        String dest_addr = Address_textfield.getText();
        if (dest_addr.isEmpty()){
            JOptionPane.showMessageDialog(null,"Destination address Error-> Please make sure that the address textbox is not empty and that you have entered a valid e-mail address");
        }
        Message message = prepareMessage(session, MyAccountEmail , dest_addr);
        Transport.send(message);
        System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session, String MyAccountEmail, String dest_addr) throws SQLException {
        try {
            Connection con = getConnection();

                System.out.println("Recipient address " + dest_addr + "\n");
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(MyAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(dest_addr));
                message.setSubject("Sailer Club - Billing Notification");
                String htmlCode = "<h1> <font size=5 face=\"verdana\"  color=\"#008000\">Billing Informations </font> </h1> <h2>  Hello " + dest_addr + ",<br> You may have to check your club fees section in the club application for more informations related to your pending club fees, <br>Have a nice day,<br>Sailer Admin </h2>";
                message.setContent(htmlCode, "text/html");
            return message;


        } catch (MessagingException e) {
            Logger.getLogger(Members_ManagementControllerClass.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }



}






