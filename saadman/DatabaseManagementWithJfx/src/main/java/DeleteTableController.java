import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteTableController {
    @FXML
    Button deleteBtn;
    @FXML
    Button backBtn;
    @FXML
    TextField tableNameTextField;
    @FXML
    Text tableDeletedText;
    Main main = new Main();

    @FXML
    void setBackBtn() throws IOException {

        main.setScene("primaryScene.fxml");
    }
    @FXML
    void setDeleteBtn() throws SQLException, ClassNotFoundException {
        String tableName = tableNameTextField.getText();
        main.deleteTable(tableName);
        tableDeletedText.setText(tableName+ " Deleted ");
        tableDeletedText.setVisible(true);
    }

}
