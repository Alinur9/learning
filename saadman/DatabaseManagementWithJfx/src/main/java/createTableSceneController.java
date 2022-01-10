import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class createTableSceneController {
    @FXML
    Button backBtn;
    @FXML
    Label tableNameLbl;
    @FXML
    TextField tableNameTextField;

    @FXML
    Button doneBtn;
    @FXML
    Label tableCreatedLbl;
    @FXML
    Label addColumnstoyourTableLbl;
    @FXML
    Button addColumnBtn;

    Main main = new Main();

    @FXML
    void setBackBtn() throws IOException {
        main.setScene("primaryScene.fxml");
    }
    @FXML
    void setDoneBtn() throws SQLException, ClassNotFoundException {
        main.createTable(tableNameTextField.getText());
        tableCreatedLbl.setText("Table Created!");
        addColumnstoyourTableLbl.setText("Now add Columns to your Table. ");
        addColumnBtn.setText("Add Column");
    }
    @FXML
    void setAddColumnBtn() throws IOException {
        main.setScene("addColumnScene.fxml");
    }
}
