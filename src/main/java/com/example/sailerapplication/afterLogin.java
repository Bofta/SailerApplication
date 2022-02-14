package com.example.sailerapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;





public class afterLogin {

    @FXML
    private Button logout;

    public void userlogout(ActionEvent event ) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Gui.fxml");
    }


}
