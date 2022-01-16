import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ProfileSceneController implements Initializable {
    @FXML
    ImageView backBtnImg;
    Main main = new Main();

    @FXML
    Label fname;
    @FXML
    Label lname;
    @FXML
    Label age;
    @FXML
    Label address;
    @FXML
    Label clg;
    @FXML
    Label usernameLbl;
    @FXML
    void setUpBackBtn() throws IOException {
        main.setScene("welcomeScene.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLbl.setText(LoginSceneController.loggedInUser);
        try {
            setprofile();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void setprofile() throws SQLException {
        Statement st = Main.connect().createStatement();
        String  q = "SELECT * FROM userinfo WHERE username='"+LoginSceneController.loggedInUser+"'";
        ResultSet rs = st.executeQuery(q);
    while (rs.next()) {
        fname.setText(rs.getString(2));
        lname.setText(rs.getString(3));
        age.setText(rs.getString(4));
        address.setText(rs.getString(5));
        clg.setText(rs.getString(6));

    }
    }

}
