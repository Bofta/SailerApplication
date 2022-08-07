package com.example.sailerapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


import static com.example.sailerapplication.DBConnector.getConnection;


public class PaymentSystem {

    @FXML
    private TextField date_field;

    @FXML
    private Button confirm_btn;

    @FXML
    private Button cancel_btn;

    @FXML
    private TextField creditcardnumber_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField exp_date_field;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField fullname_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField securitycode_field;

    @FXML
    private TextField username_field;


    @FXML
    private void VerifyInput(){
        if ( creditcardnumber_field.getText().isEmpty()== true ||  exp_date_field.getText().isEmpty()== true || securitycode_field.getText().isEmpty()== true){
            JOptionPane.showMessageDialog(null, "Please enter a valid input");
        }

    }

    @FXML
    private void ConfirmButtonAction() throws SQLException, MessagingException {
        VerifyInput();
        Connection con = getConnection();
        PreparedStatement strUpdate = con.prepareStatement("UPDATE user set CCBalance= CCBalance-2000 where name=" + "'" + firstname_field.getText() + "'");
        System.out.println("The SQL statement is: " + strUpdate + "\n");
        strUpdate.executeUpdate();
        sendMail_Billing_Informations();
        JOptionPane.showMessageDialog(null, "Hi Mr/Ms " + fullname_field.getText() + "\nAn email has been sent to " + email_field.getText() + "\nwith all the relative billing information\nHave a nice day");
        Stage stage = (Stage) confirm_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) cancel_btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void sendMail_Billing_Informations() throws MessagingException, SQLException {
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

        String dest_addr = email_field.getText();
        if (dest_addr.isEmpty()){
            JOptionPane.showMessageDialog(null,"Destination address Error-> Please make sure that the address textbox is not empty and that you have entered a valid e-mail address");
        }
        Message message = prepareMessage(session, MyAccountEmail , dest_addr);
        Transport.send(message);
        System.out.println("Message sent successfully");
        Connection con = getConnection();
        PreparedStatement posted_parkingFees_notification = con.prepareStatement("INSERT INTO payment (title, date , payer) VALUES ('transaction trace','" + date_field.getText() + "','"+fullname_field.getText() + "')");
        posted_parkingFees_notification.executeUpdate();

    }

    private static Message prepareMessage(Session session, String MyAccountEmail, String dest_addr) throws SQLException {
        try {
            Connection con = getConnection();

            System.out.println("Recipient address " + dest_addr + "\n");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(dest_addr));
            message.setSubject("Sailer Club - Billing Notification");
            String htmlCode = "<h1> <font size=5 face=\"verdana\"  color=\"#008000\">Billing Informations </font> </h1> <h2>  Hello " + dest_addr + ",<br> You have successfully payed a transaction <br>Your credit balance has been charged <br>Don't forget to check your membership status, parking fees in your app B&C section, <br>Have a nice day,<br>Sailer Admin </h2>";
            message.setContent(htmlCode, "text/html");
            return message;


        } catch (MessagingException e) {
            Logger.getLogger(Members_ManagementControllerClass.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }




}
