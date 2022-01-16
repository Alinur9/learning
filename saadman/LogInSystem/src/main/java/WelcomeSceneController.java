import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class WelcomeSceneController implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label homeLbl;
    @FXML
    Label profileLbl;
    @FXML
    Label inboxLbl;
    @FXML
    Label usernameLbl;

    @FXML
    void setUpProfileLbl() throws IOException, SQLException {
        Main main = new Main();
        Statement st = Main.connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM userinfo where username='"+LoginSceneController.loggedInUser+"'");
        if(rs.next())
        {
            main.setScene("profileScene.fxml");
        }
        else main.setScene("updateProfileScene.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLbl.setText(LoginSceneController.loggedInUser);
    }
}
