import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
    static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("SignUpScene2.fxml"));
        stg.setScene(new Scene(root));
        stg.show();
    }
//    public void setScene(String fxmlPath) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
//        Scene scene = new Scene(root);
//        stg.setScene(scene);
//    }
    public static Connection connect() throws SQLException {
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
    public static void createTable() throws SQLException {
        Statement st =connect().createStatement();
        st.execute("CREATE TABLE users(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),username VARCHAR(255),email varchar(255),password VARCHAR(255))");
    }
    public static void addData(String username,String email,String password) throws SQLException {
        Statement st = connect().createStatement();
        String q = "INSERT INTO users(username,email,password) VALUES ('"+username+"','"+email+"','"+password+"')";
        st.execute(q);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
