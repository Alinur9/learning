import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class showTableController {
    @FXML
    Button showTableBtn;
    @FXML
    TextField tableNameTextField;
    @FXML
    Text tableResText;
    @FXML
    Button backBtn;
    @FXML
    void setShowTableBtn() throws SQLException, ClassNotFoundException {
        String showTableResult = showTableRes(tableNameTextField.getText());
        tableResText.setText(showTableResult);
        tableResText.setVisible(true);
    }
    @FXML
    void setBackBtn() throws IOException {
        Main main = new Main();
        main.setScene("primaryScene.fxml");
    }
    String showTableRes(String tableName) throws SQLException, ClassNotFoundException {
        String res = "";
        ResultSet rs =  Main.showTable(tableName);

        ArrayList<String> cols =Main.map.get(tableName);
        while (rs.next())
        {
            res = res + rs.getInt(1) + " ";
            int index = 2;
            while(index-1<=cols.size())
            {
                res =res + rs.getString(index) + " ";
                index++;
            }
            res = res + "\n";
        }
        return res;
    }
}
