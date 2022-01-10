import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class addDataController {
    String insert = "INSERT INTO users(name,age,phone) values ('Sifat','21','201234')";
    String tableName;
    String data = "('";
    String variables = "(";
    ArrayList<String> cols;
    @FXML
    AnchorPane pane;
    @FXML
     Label columnNameLbl;
    @FXML
    Button nextBtn;
    @FXML
    Button doneBtn;
    @FXML
    TextField dataTextField;
    int count=1;
    int index = 0;
    @FXML
    Button finishBtn;

    @FXML
    void setNextBtn() throws IOException, SQLException, ClassNotFoundException {
        data = data +dataTextField.getText();
        if(count<cols.size())
        {
            data=data+"', '";
            variables=variables+",";
        }
        if(count==cols.size())
        {
            pane.getChildren().remove(nextBtn);
            data = data+"')";
            variables=variables+")";
            Main main = new Main();
            main.addData(tableName,data,variables);
            finishBtn.setVisible(true);
            nextBtn.setVisible(false);
            System.out.println("Data Added Successfully");
            return;
        }
        variables=variables+cols.get(count);
        String colName = cols.get(count);
        columnNameLbl.setText(colName);
        count++;

    }
    @FXML
    void setDoneBtn() throws IOException {
       tableName = dataTextField.getText();
       nextBtn.setVisible(true);
       cols =  Main.map.get(tableName);
       columnNameLbl.setText(Main.map.get(tableName).get(0));
       variables=variables+cols.get(0);
    }
    @FXML
    void setFinishBtn() throws IOException {
        Main main = new Main();
        main.setScene("primaryScene.fxml");
    }



}
