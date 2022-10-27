package com.example.worldc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
public class BoardCustomController {
    @FXML
    private Label id_user;
    @FXML
    private TextField tf_m1t1 ;
    @FXML
    private TextField tf_m1t2;
    @FXML
    private TextField tf_m2t1;
    @FXML
    private TextField tf_m2t2;
    @FXML
    private TextField tf_m3t1;
    @FXML
    private TextField tf_m3t2;
    @FXML
    private TextField tf_m4t1;
    @FXML
    private TextField tf_m4t2;
    @FXML
    private TextField tf_m5t1;
    @FXML
    private TextField tf_m5t2;
    @FXML
    private TextField tf_m6t1;
    @FXML
    private TextField tf_m6t2;
    @FXML
    private PasswordField tf_pass;

    @FXML
    private Label lbl_tom_1;

    @FXML
    private Label lbl_tom_2;

    @FXML
    private Label lbl_tom_3;

    @FXML
    private Label lbl_tom_4;

    @FXML
    private Label lbl_tom_5;

    @FXML
    private Label lbl_tom_6;

////    public void onUpdate(ActionEvent event) throws SQLException {
////        String pwd = DataBase.getPwd(id_user.getText());
////        if (pwd.equals(tf_pass.getText())){
////            if(tf_m1t1.getText() != null  && tf_m1t2.getText()!= null ) {
////                DataBase.update("match1", tf_m1t1.getText(), tf_m1t2.getText());
////            }
////            if(tf_m2t1.getText() != null && tf_m2t2.getText()!= null ) {
////                DataBase.update("match2", tf_m2t1.getText(), tf_m2t2.getText());
////            }
////            if(tf_m3t1.getText() != null && tf_m3t2.getText()!= null) {
////                DataBase.update("match3", tf_m3t1.getText(), tf_m3t2.getText());
////            }
////            if(tf_m4t1.getText() != null && tf_m4t2.getText()!= null) {
////                DataBase.update("match4", tf_m4t1.getText(), tf_m4t2.getText());
////            }
////            if(tf_m5t1.getText() != null && tf_m5t2.getText()!= null) {
////                DataBase.update("match5", tf_m5t1.getText(), tf_m5t2.getText());
////            }
////            if(tf_m6t1.getText() != null && tf_m6t2.getText()!= null) {
////                DataBase.update("match6", tf_m6t1.getText(), tf_m6t2.getText());
////            }
////            tf_pass.setText("");
////            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
////            alert.setContentText("Data updated !");
////            alert.show();
////        }else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Password Incorrect !");
//            alert.show();
//        }
//    }
    public void userInformation(String data,String m1t1 ,String m1t2,String m2t1,String m2t2,String m3t1,String m3t2,String m4t1,String m4t2,String m5t1,String m5t2,String m6t1,String m6t2,String m1tom,String m2tom,String m3tom,String m4tom,String m5tom,String m6tom){
        id_user.setText(data);
        tf_m1t1.setText(m1t1);
        tf_m1t2.setText(m1t2);
        tf_m2t1.setText(m2t1);
        tf_m2t2.setText(m2t2);
        tf_m3t1.setText(m3t1);
        tf_m3t2.setText(m3t2);
        tf_m4t1.setText(m4t1);
        tf_m4t2.setText(m4t2);
        tf_m5t1.setText(m5t1);
        tf_m5t2.setText(m5t2);
        tf_m6t1.setText(m6t1);
        tf_m6t2.setText(m6t2);

        lbl_tom_1.setText(m1tom);
        lbl_tom_2.setText(m2tom);
        lbl_tom_3.setText(m3tom);
        lbl_tom_4.setText(m4tom);
        lbl_tom_5.setText(m5tom);
        lbl_tom_6.setText(m6tom);
    }
    @FXML
    void onBoard(ActionEvent event) throws IOException, SQLException {
        String pwd = DataBase.getPwd(id_user.getText());
       DataBase.logIn(id_user.getText(),pwd,"access");
    }


    @FXML
    void onTable(ActionEvent event) throws IOException {
        HelloApplication.setScene(id_user.getText(),"board-custom-table.fxml","Table");
    }
    @FXML
    void onLogOut(ActionEvent event) throws IOException {
        HelloApplication.setScene(null,"log-in.fxml","LogIn");
    }
}