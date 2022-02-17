package com.example.sailerapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;





public class afterLogin_user_dashboard {

    @FXML
    private Button logout;

    public void userlogout(ActionEvent event ) throws IOException {
        SailerApplicaton m = new SailerApplicaton();
        m.changeScene("Gui.fxml");
    }


}
