import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    static Stage stg;
    static HashMap<String, ArrayList<String>> map;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("primaryScene.fxml"));
        stg.setScene(new Scene(root,600,400));
        stg.show();
    }
    public void setScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(root));
    }
    public static Connection connectToDerby() throws ClassNotFoundException, SQLException {
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
        Statement st = connectToDerby().createStatement();
        String createQuery = "CREATE TABLE "+tableName+" (id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1))";
        st.execute(createQuery);
        map = new HashMap<>();
        map.put(tableName,new ArrayList<>());
        System.out.println("Table Created.");
    }
    public void addColumn(String tableName,String columnName) throws SQLException, ClassNotFoundException {
        Statement st = connectToDerby().createStatement();
        String addColumnQuery = "ALTER TABLE "+tableName+" ADD "+columnName+" VARCHAR(255)";
        st.executeUpdate(addColumnQuery);
        map.get(tableName).add(columnName);
        System.out.println("Column Added.");
    }
    public void addData(String tableName,String data,String variables) throws SQLException, ClassNotFoundException {
        Statement st = connectToDerby().createStatement();
        String addDataQuery = "INSERT INTO "+tableName+variables+" VALUES "+data;
        st.execute(addDataQuery);
        System.out.println("Data Added.");
    }
    public static ResultSet showTable(String tableName) throws SQLException, ClassNotFoundException {
        Statement st = connectToDerby().createStatement();
        return st.executeQuery("SELECT * FROM "+tableName+" ORDER BY ID ASC");
    }
    public void deleteTable(String tableName) throws SQLException, ClassNotFoundException {
        String deleteQuery = "DROP TABLE "+tableName;
        Statement st = connectToDerby().createStatement();
        st.execute(deleteQuery);
        System.out.println(tableName +" deleted." );
    }
    public static void main(String[] args) {
        launch(args);
    }
}
