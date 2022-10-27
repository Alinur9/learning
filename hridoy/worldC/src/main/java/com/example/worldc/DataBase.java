package com.example.worldc;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.sql.*;
public class DataBase {
    private static Connection connection;
    private static final String SELECT_QUERY = "SELECT * FROM user_data WHERE username = ?";
    private static final String SELECT_QUERY_UT = "SELECT * FROM users_teams WHERE username = ?";
    private static final String SELECT_QUERY_MID = "SELECT * FROM team_vs_team WHERE match_id = ?";
    private static final String SELECT_QUERY1 = "INSERT INTO user_data" + "(username ,password,email,role)" + "VALUES (?,?,?,?)";
    private static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cricket", "root", "Ahsan123@");
        }
        return connection;
    }
    public static ResultSet executeQuery(String data ,String query) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, data);
        return stmt.executeQuery();
    }
    public static String getUserName(String email,String query) throws SQLException {
        ResultSet resultSet = executeQuery(email,query);
        if (!resultSet.next())
            return null;
        return resultSet.getString("username");

    }
    public static String getPwd(String username) throws SQLException {
        ResultSet resultSet = executeQuery(username,SELECT_QUERY);
        if (!resultSet.next())
            return null;
        return  resultSet.getString("password");
    }
    public static String getEmail(String email) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_data WHERE email = ?");
        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next())
            return null;
        return  resultSet.getString("email");
    }
    public static String getRole(String username) throws SQLException {
        ResultSet resultSet = executeQuery(username,SELECT_QUERY);
        if (!resultSet.next())
            return null;
        return  resultSet.getString("role");
    }
    public static String getMatchId(String MID) throws SQLException {
        ResultSet resultSet = executeQuery(MID,SELECT_QUERY_MID);
        if (!resultSet.next())
            return null;
        return  resultSet.getString("match_id");
    }
    public static String getUserMatchId(String user) throws SQLException {
        ResultSet resultSet = executeQuery(user,SELECT_QUERY_UT);
        if (!resultSet.next())
            return null;
        return  resultSet.getString("match_id");
    }
    public static void signIn(String username,String password,String email,String code) {
        PreparedStatement preparedStatement ;
        try{
            if (getPwd(username) != null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("User Already exists !");
                alert.show();
            }
            else {
                connection = getConnection();
                preparedStatement = connection.prepareStatement(SELECT_QUERY1);

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.setString(3,email);
                preparedStatement.setString(4, code);
                preparedStatement.executeUpdate();

                HelloApplication.setScene(username,"board-table.fxml","Score Table");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
        public static void logIn (String username, String password,String access){

            try {
                String pwd = getPwd(username);
                String code = getRole(username);
                String user = getUserName(username,"SELECT * FROM user_data WHERE username = ?");
                if (user == null){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("user !");
                    alert.show();
                }
                if (pwd != null && pwd.equals(password) && user != null) {
                    if (code != null && access == null){
                        HelloApplication.setScene(username,"board-custom-table.fxml","Custom");
                    }else {
                        HelloApplication.setScene(username, "board-table.fxml", "Score Table");
                    }
                }if (pwd != null &&!pwd.equals(password)){
                    System.out.println("Password didn't match");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Password Incorrect !");
                    alert.show();
                }
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void update(String query) {
            try {

                connection = getConnection();
                PreparedStatement pstUpdate = connection.prepareStatement(query);
                pstUpdate.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
