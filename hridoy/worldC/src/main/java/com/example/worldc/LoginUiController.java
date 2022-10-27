package com.example.worldc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.sql.SQLException;

public class LoginUiController {
    LoginController controller = new LoginController();
    @FXML
    private CheckBox source_check_box;
    @FXML
    private Button btn_verify;
    @FXML
    private   Button btn_sign;
    @FXML
    private Button btn_reg;
    @FXML
    private Button btn_login;
    @FXML
    private PasswordField tf_password;
    @FXML
    private TextField tf_visible_pass;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_verify_email;
    @FXML
    private PasswordField tf_newpass;
    @FXML
    private PasswordField tf_confirmpass;
    @FXML
    private Pane pane_verify_forget_pass;
    @FXML
    private Pane pane_confirmation;
    
    @FXML
    private Pane body;
    @FXML
    void onLogIn(ActionEvent event) throws IOException {

        if (!tf_username.getText().contains(" ") && !tf_username.getText().isEmpty() && !tf_password.getText().isEmpty()){
            DataBase.logIn(tf_username.getText(),tf_password.getText(),null);
        }else {
            System.out.println("Invalid Step");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fill up your username and password correctly !");
            alert.show();
        }
    }
    @FXML
    void checkBox(ActionEvent event){
        if (source_check_box.isSelected()){
            tf_visible_pass.setText(tf_password.getText());
            tf_visible_pass.setVisible(true);
            tf_password.setVisible(false);
            return;
        }
            tf_password.setText(tf_visible_pass.getText());
            tf_password.setVisible(true);
            tf_visible_pass.setVisible(false);

    }
    @FXML
    void onReg(ActionEvent event) throws IOException {
        HelloApplication.setScene(null,"sign-up.fxml","Sign in");
    }

    public void buttonForgetPass(ActionEvent event) {

        pane_verify_forget_pass.setVisible(true);
        tf_verify_email.setVisible(true);
        btn_sign.setVisible(true);
        btn_verify.setVisible(true);
        pane_confirmation.setVisible(false);
    }
@FXML
    public void onVerify(ActionEvent event) throws SQLException {
        if (DataBase.getEmail(tf_verify_email.getText()) != null){
            tf_verify_email.setVisible(false);
            btn_sign.setVisible(false);
            btn_verify.setVisible(false);
            pane_confirmation.setVisible(true);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("information incorrect !");
            alert.show();
        }

    }

    public void onSignIn(ActionEvent event) {
            pane_verify_forget_pass.setVisible(false);
            tf_verify_email.setText("");
    }
    public void onConfirm(ActionEvent event) throws SQLException {
        String confirmPass = tf_confirmpass.getText();
        String newPass = tf_newpass.getText();
        String email = tf_verify_email.getText();
        controller.updatePassword(email, confirmPass, newPass);
    }




}
