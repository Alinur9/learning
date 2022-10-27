package com.example.worldc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class BoardController {
    @FXML
    private Label id_warning;
    @FXML
    private Label id_team = null;
    @FXML
    private Label id_user;
    @FXML
    private Label id_admin;
    @FXML
    private Label id_1;
    @FXML
    private Label id_m1_t1;
    @FXML
    private Label id_m1_t2;
    @FXML
    private Label id_m1_tom;
    @FXML
    private Label id_m2_t1;
    @FXML
    private Label id_m2_t2;
    @FXML
    private Label id_m2_tom;
    @FXML
    private Label id_m3_t1;
    @FXML
    private Label id_m3_t2;
    @FXML
    private Label id_m3_tom;
    @FXML
    private Label id_m4_t1;
    @FXML
    private Label id_m4_t2;
    @FXML
    private Label id_m4_tom;
    @FXML
    private Label id_m5_t1;
    @FXML
    private Label id_m5_t2;
    @FXML
    private Label id_m5_tom;
    @FXML
    private Label id_m6_t1;
    @FXML
    private Label id_m6_t2;
    @FXML
    private Label id_m6_tom;
    @FXML
    void onBack(ActionEvent event) throws IOException, SQLException {
        if (Objects.equals(DataBase.getRole(id_user.getText()), "pepsi") && DataBase.getRole(id_user.getText()) != null){
           DataBase.logIn(id_user.getText(),DataBase.getPwd(id_user.getText()),null);
        }
//            HelloApplication.setScene(null, "log-in.fxml", "Login", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//        }
    }
    public void userInformation(String user,String code,String data,String m1t1,String m1t2,String m1tom,String m2t1, String m2t2, String m2tom ,String m3t1,String m3t2,String m3tom,String m4t1,String m4t2,String m4tom,String m5t1,String m5t2,String m5tom,String m6t1,String m6t2,String m6tom) {
        id_user.setText(user);
        id_1.setText(data);
        id_m1_t1.setText(m1t1);
        id_m1_t2.setText(m1t2);
        id_m1_tom.setText(m1tom);
        id_m2_t1.setText(m2t1);
        id_m2_t2.setText(m2t2);
        id_m2_tom.setText(m2tom);
        id_m3_t1.setText(m3t1);
        id_m3_t2.setText(m3t2);
        id_m3_tom.setText(m3tom);
        id_m4_t1.setText(m4t1);
        id_m4_t2.setText(m4t2);
        id_m4_tom.setText(m4tom);
        id_m5_t1.setText(m5t1);
        id_m5_t2.setText(m5t2);
        id_m5_tom.setText(m5tom);
        id_m6_t1.setText(m6t1);
        id_m6_t2.setText(m6t2);
        id_m6_tom.setText(m6tom);
        if (code != null) {
            id_admin.setText("Admin");
        }
    }
    @FXML
    void onTable(ActionEvent event) throws IOException {
        HelloApplication.setScene(id_user.getText(),"board-table.fxml","Table");
    }
@FXML
    void onLogOut(ActionEvent event) throws IOException {
        HelloApplication.setScene(null,"log-in.fxml","LogIn");
    }
    }




