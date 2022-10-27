package com.example.worldc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class SignController {
    @FXML
    private TextField tf_email;
    @FXML
    private PasswordField tf_pass;
    @FXML
    private PasswordField tf_rePass;
    @FXML
    private TextField tf_username;

    @FXML
    private Label id_warning;



    @FXML
    void onCancel(ActionEvent event) {
        tf_username.setText("");
        tf_email.setText("");
        tf_pass.setText("");
        tf_rePass.setText("");
    }
    @FXML
    void onSubmit(ActionEvent event) throws SQLException {
        String code = "pepsi";
        if (!tf_username.getText().contains(" ") && !tf_username.getText().isEmpty() && !tf_pass.getText().isEmpty()){
            if (!tf_pass.getText().equals(tf_rePass.getText())){
                id_warning.setText("Password not matches !");
            }
            else {
                    DataBase.signIn(tf_username.getText(),tf_pass.getText(),tf_email.getText(),null);
                }
        }else {
            System.out.println("Invalid Step");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fill up your Information correctly !");
            alert.show();

        }
    }

    @FXML
    void onLogIn(ActionEvent event) throws IOException {
        HelloApplication.setScene(null,"log-in.fxml","Log in");
    }
}
