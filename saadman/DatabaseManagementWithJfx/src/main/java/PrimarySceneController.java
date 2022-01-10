import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrimarySceneController {
    @FXML
    Button createTableBtn;
    @FXML
    Button addDataBtn;
    @FXML
    Button showTableBtn;
    @FXML
    Button deleteTableBtn;
    Main main = new Main();

    @FXML
    void setCreateTableBtn() throws IOException {
        main.setScene("createTableScene.fxml");
    }
    @FXML
    void setAddDataBtn() throws IOException {

        main.setScene("addDataScene.fxml");
    }
    @FXML
    void setShowTableBtn() throws IOException {

        main.setScene("showTableScene.fxml");
    }
    @FXML
    void setDeleteTableBtn() throws IOException {
        main.setScene("deleteTableScene.fxml");
    }
}
