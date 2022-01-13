import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginSceneController {
    Alert alert = new Alert(Alert.AlertType.NONE);
    ResultSet rs;
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    Button loginBtn;
    @FXML
    Button signUpBtn;

    @FXML
    void setLoginBtn() throws SQLException {
        if(usernameTextField.getText().equals("") || passwordTextField.getText().equals(""))
        {
            alert.setContentText("Field cannot be empty");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.show();
        }
        else
        {
            Statement st = Main.connect().createStatement();
            rs = st.executeQuery("SELECT * FROM users WHERE username='"+usernameTextField.getText()+"' AND password='"+passwordTextField.getText()+"'");
            if(rs.next())
            {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Logged In Successfully");
                alert.show();
            }
            else
            {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Wrong Username or Password");
                alert.show();
            }
        }
    }
    @FXML
    void setSignUpBtn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpScene2.fxml"));
        Main.stg.setScene(new Scene(root));
    }

}
