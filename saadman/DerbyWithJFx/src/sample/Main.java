package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        Button createTable = new Button("Create Table");
        createTable.setLayoutY(5);
        createTable.setLayoutX(10);

        Button showTable = new Button("Show Table");
        showTable.setLayoutY(5);
        showTable.setLayoutX(100);

        Button addData = new Button("Add Data");
        addData.setLayoutY(5);
        addData.setLayoutX(190);

        Label tableNameLabel = new Label("Table Name :  ");
        tableNameLabel.setLayoutY(42);
        tableNameLabel.setLayoutX(10);
        TextField tableNameTextFieled = new TextField();
        tableNameTextFieled.setLayoutY(60);
        tableNameTextFieled.setLayoutX(10);

        Label userNameLabel = new Label("Username : ");
        userNameLabel.setLayoutY(85);
        userNameLabel.setLayoutX(10);
        TextField userNameTextField = new TextField();
        userNameTextField.setLayoutY(110);
        userNameTextField.setLayoutX(10);

        Label nameLabel = new Label("Name : ");
        nameLabel.setLayoutY(135);
        nameLabel.setLayoutX(10);

        TextField nameTextField = new TextField();
        nameTextField.setLayoutY(160);
        nameTextField.setLayoutX(10);

        Label phoneNoLabel = new Label("Phone NO : ");
        phoneNoLabel.setLayoutY(185);
        phoneNoLabel.setLayoutX(10);
        TextField phoneNoTextField = new TextField();
        phoneNoTextField.setLayoutY(210);
        phoneNoTextField.setLayoutX(10);

        Button enter = new Button("Enter");
        enter.setLayoutY(90);
        enter.setLayoutX(10);

        Button enter2 = new Button("Enter");
        enter2.setLayoutY(90);
        enter2.setLayoutX(10);

        Button enter3 = new Button("Enter");
        enter3.setLayoutY(235);
        enter3.setLayoutX(10);

        Text tableCreatedMessage = new Text();
        tableCreatedMessage.setText(" Table Created! ");
        tableCreatedMessage.setX(100);
        tableCreatedMessage.setY(120);

        Text showTableResults = new Text();
        showTableResults.setX(100);
        showTableResults.setY(140);



        Group g1 = new Group(createTable,showTable,addData);
        Scene s1 = new Scene(g1,300,300);
        stage.setScene(s1);
        stage.setTitle("Apache Derby Test.");
        stage.show();

        createTable.setOnAction(value ->{
            g1.getChildren().remove(enter);
            g1.getChildren().remove(enter2);
            g1.getChildren().remove(enter3);
            g1.getChildren().remove(tableNameLabel);
            g1.getChildren().remove(tableNameTextFieled);
            g1.getChildren().remove(tableCreatedMessage);
            g1.getChildren().remove(userNameLabel);
            g1.getChildren().remove(userNameTextField);
            g1.getChildren().remove(nameLabel);
            g1.getChildren().remove(nameTextField);
            g1.getChildren().remove(phoneNoLabel);
            g1.getChildren().remove(phoneNoTextField);
            g1.getChildren().remove(showTableResults);


            g1.getChildren().add(tableNameLabel);
            g1.getChildren().add(tableNameTextFieled);
            g1.getChildren().add(enter);

        });
        enter.setOnAction(value ->{

            try {
                String tableName = tableNameTextFieled.getText();
                createTable(tableName);
            } catch (SQLException throwables) {
                System.out.println("Something went wrong. Table couldn't be created. ");
                tableCreatedMessage.setText("Table couldn't be created.");
            } catch (ClassNotFoundException e) {
                System.out.println("Something went wrong. Table couldn't be created. ");
                tableCreatedMessage.setText("Table couldn't be created.");
            }
            finally {
                g1.getChildren().add(tableCreatedMessage);
            }
        });
        addData.setOnAction(value->
        {
            g1.getChildren().remove(enter);
            g1.getChildren().remove(enter2);
            g1.getChildren().remove(enter3);
            g1.getChildren().remove(tableNameLabel);
            g1.getChildren().remove(tableNameTextFieled);
            g1.getChildren().remove(tableCreatedMessage);
            g1.getChildren().remove(userNameLabel);
            g1.getChildren().remove(userNameTextField);
            g1.getChildren().remove(nameLabel);
            g1.getChildren().remove(nameTextField);
            g1.getChildren().remove(phoneNoLabel);
            g1.getChildren().remove(phoneNoTextField);
            g1.getChildren().remove(showTableResults);


            g1.getChildren().add(tableNameLabel);
            g1.getChildren().add(tableNameTextFieled);

            g1.getChildren().add(userNameLabel);
            g1.getChildren().add(userNameTextField);

            g1.getChildren().add(nameLabel);
            g1.getChildren().add(nameTextField);

            g1.getChildren().add(phoneNoLabel);
            g1.getChildren().add(phoneNoTextField);

            g1.getChildren().add(enter3);
        });
        enter3.setOnAction(value ->{
            String tableName = tableNameTextFieled.getText();
            String userName = userNameTextField.getText();
            String name = nameTextField.getText();
            Long phoneNO = Long.valueOf(phoneNoTextField.getText());
            try {
                insert(tableName,userName,name,phoneNO);
            } catch (SQLException throwables) {
                System.out.println("Something went wrong.");
            } catch (ClassNotFoundException e) {
                System.out.println("Something went wrong.");
            }
            System.out.println("Data Added to DB. ");
        });
        showTable.setOnAction(value ->
        {
            g1.getChildren().remove(enter);
            g1.getChildren().remove(enter2);
            g1.getChildren().remove(enter3);
            g1.getChildren().remove(tableNameLabel);
            g1.getChildren().remove(tableNameTextFieled);
            g1.getChildren().remove(tableCreatedMessage);
            g1.getChildren().remove(userNameLabel);
            g1.getChildren().remove(userNameTextField);
            g1.getChildren().remove(nameLabel);
            g1.getChildren().remove(nameTextField);
            g1.getChildren().remove(phoneNoLabel);
            g1.getChildren().remove(phoneNoTextField);
            g1.getChildren().remove(showTableResults);



            g1.getChildren().add(tableNameLabel);
            g1.getChildren().add(tableNameTextFieled);
            g1.getChildren().add(enter2);
        });
        enter2.setOnAction(value ->{
            String tableName = tableNameTextFieled.getText();
            try {
                ResultSet rs  = showTable(tableName);
                System.out.println("Getting the table.... ");
                String res = "";
                while (rs.next())
                {
                    res= res + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getLong(4) + "\n";

                }
                showTableResults.setX(10);
                showTableResults.setText(res);
                g1.getChildren().add(showTableResults);
            } catch (SQLException throwables) {
                System.out.println("Something went wrong. ");
            } catch (ClassNotFoundException e) {
                System.out.println("Something went wrong. ");
            }
        });
    }
    public Connection connectToDerby() throws ClassNotFoundException, SQLException {
        System.out.println("Connecting to Database...   ");
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(DRIVER);
        final String JDBC_URL = "jdbc:derby:CreatingJavaDB;create=true";
        Connection conn = DriverManager.getConnection(JDBC_URL);
        if(conn!=null)
        {
            System.out.println("Connected Successfully.");
        }
        else {
            System.out.println("Failed to connect. ");
        }
        return conn;
    }
    public void createTable(String tableName) throws SQLException, ClassNotFoundException {

        Statement st =connectToDerby().createStatement();
        String create = "CREATE TABLE "+tableName+"(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),username VARCHAR(255) NOT NULL," +
                "name VARCHAR(255)NOT NULL,phoneNo BIGINT NOT NULL)";
        st.execute(create);
        System.out.println("Table created. ");
    }
    public ResultSet showTable(String tableName) throws SQLException, ClassNotFoundException {
        Statement st = connectToDerby().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM "+tableName+" ORDER BY ID ASC");
        return rs;
    }
    public void insert(String tableName,String username,String name,long phoneNo) throws SQLException, ClassNotFoundException {
        Statement st =connectToDerby().createStatement();
        String insertQuery = "INSERT INTO "+tableName+"(username,name,phoneNo) VALUES ('"+username+"','"+name+"',"+phoneNo+")";
        st.execute(insertQuery);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
