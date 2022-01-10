import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AddColumnSceneController {
    @FXML
    Label tableNameLbl;
    @FXML
    TextField tableNameTextField;
    @FXML
    Label columnNameLbl;
    @FXML
    TextField columnNameTextField;
    @FXML
    Button addColumnBtn;
    @FXML
    Button backBtn;
    Main main = new Main();
    @FXML
    void setBackBtn() throws IOException {
        main.setScene("primaryScene.fxml");
    }
    @FXML
    void setAddColumnBtn() throws SQLException, ClassNotFoundException {
        main.addColumn(tableNameTextField.getText(),columnNameTextField.getText());
    }
}
