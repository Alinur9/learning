package com.xyz.profiler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class Database {
    String currentUserName = "";
    String currentUserEmail = "";
    public Database() throws Exception {
        isTableExist("ACCOUNTS");
    }
    public void addAccount(String userName,String email,String password) throws Exception {

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "INSERT INTO ACCOUNTS (USERNAME, EMAIL, PASSWORD) VALUES ('"
                +  userName + "', '" + email + "', '" + password + "')";
        statement.execute(query);

    }
    public void addProfile(String name, String lastName,String occupation,String company,String age,String gender,
                           String relationshipStatus)throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String email = getEmail(currentUserName);
        String query = "INSERT INTO PROFILES (USERNAME, EMAIL, NAME, LASTNAME, OCCUPATION, COMPANY, AGE, RELATIONSHIP_STATUS, " +
                "GENDER) VALUES('"+currentUserName+"', '"+email+ "', '" +name+ "', '" +lastName+ "', '" +occupation+ "', '" +
                company+ "', '" +age+ "', '" +relationshipStatus+ "', '" +gender+ "')" ;
        statement.execute(query);
    }
    public void addImage(String path)throws Exception{
        File image = new File(path);
        FileInputStream inputStream = new FileInputStream(image);
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PICTURES (USERNAME, IMAGE)" +
                " VALUES(?,?)");
        preparedStatement.setString(1,currentUserName);
        preparedStatement.setBinaryStream(2,inputStream,image.length());
        int s = preparedStatement.executeUpdate();
        if(s>0)
            System.out.println("Uploaded successfully !");
        else
            System.out.println("unsucessfull to upload image.");
    }

    public void updateProfile(String name, String lastName,String occupation,String company,String age,String gender,
                              String relationshipStatus)throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String email = getEmail(currentUserName);
        String query = "UPDATE PROFILES SET USERNAME = '"+currentUserName+"', EMAIL = '"+email+"', NAME = '"+name+"'," +
                " LASTNAME = '"+lastName+"', OCCUPATION = '"+occupation+"', COMPANY = '"+company+"', AGE = '"+age+"', " +
                "RELATIONSHIP_STATUS  = '"+relationshipStatus+"', GENDER = '"+gender+"' WHERE USERNAME = '" +currentUserName+
                "'";
        statement.executeUpdate(query);
    }
    public boolean isTableExist(String sTablename) throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        if(connection!=null)
        {
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename,null);
            if(rs.next())
            {
                System.out.println("Table");
            }
            else
            {
                String query1 = "CREATE TABLE ACCOUNTS (USERNAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255))";
                statement.execute(query1);
                String query2 = "CREATE TABLE PROFILES (USERNAME VARCHAR(255),EMAIL VARCHAR(255),NAME VARCHAR(255), " +
                        "LASTNAME VARCHAR(255) ,OCCUPATION VARCHAR(255), COMPANY VARCHAR(255), " +
                        "AGE VARCHAR(255), RELATIONSHIP_STATUS  VARCHAR(255), GENDER VARCHAR(255))";
                statement.execute(query2);
                String query3 = "CREATE TABLE PICTURES (USERNAME VARCHAR(255), IMAGE BLOB)";
                statement.execute(query3);
            }
            return true;
        }
        return false;
    }
    public boolean userNameExists(String userName,String email)throws Exception{
        boolean result = false;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME, EMAIL FROM ACCOUNTS";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String userNames = resultSet.getString("USERNAME");
            String emails = resultSet.getString("EMAIL");
            if (userNames.equals(userName) || emails.equals(email)){
                result = true;
                break;
            }
        }
        return result;
    }
    private String stringResult(String columnName, String tableName)throws Exception{
        String result = "";
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME, "+columnName+" FROM "+tableName;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String userNames = resultSet.getString("USERNAME");
            String firstNames = resultSet.getString(columnName);
            if (userNames.equals(currentUserName)){
                result = firstNames;
                break;
            }
        }
        return result;
    }
    public boolean accountExists(String userName)throws Exception{
        boolean result = false;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME FROM ACCOUNTS";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String userNames = resultSet.getString("USERNAME");
            if (userNames.equals(userName)){
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean passwordCorrect(String userName, String password) throws Exception {
        boolean result = false;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME, PASSWORD FROM ACCOUNTS";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String userNames = resultSet.getString("USERNAME");
            String password1 = resultSet.getString("PASSWORD");
            if (userNames.equals(userName) && password1.equals(password)) {
                currentUserName = userName;
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean profileExists(String userName) throws Exception{
        boolean result = false;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME FROM PROFILES";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String userNames = resultSet.getString("USERNAME");
            if (userNames.equals(userName)){
                result = true;
                break;
            }
        }
        return result;
    }
    public BufferedImage pictureExists(String userName)throws Exception{
        BufferedImage result = null;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT USERNAME, IMAGE FROM PICTURES";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String userNames = resultSet.getString("USERNAME");
            Blob picture = resultSet.getBlob("IMAGE");
            InputStream inputStream = picture.getBinaryStream();
            BufferedImage imageView = ImageIO.read(inputStream);
            if (userNames.equals(userName)) {
                currentUserName = userName;
                result =imageView;
                break;
            }
        }
        return result;
    }
    private String getEmail(String userName)throws Exception{
        String result = stringResult("EMAIL","ACCOUNTS");
        return result;
    }
    public String getCurrentUserName(){
        return currentUserName;
    }
    public String getCurrentUserEmail()throws Exception{
       currentUserEmail = getEmail(currentUserName);
       return currentUserEmail;
    }
    public String getFirstName() throws Exception{
        String result = stringResult("NAME","PROFILES");
        return result;
    }
    public String getLastName() throws Exception{
        String result = stringResult("LASTNAME","PROFILES");
        return result;
    }
    public String getOccupation() throws Exception{
        String result = stringResult("OCCUPATION","PROFILES");
        return result;
    }
    public String getCompany() throws Exception{
        String result = stringResult("COMPANY","PROFILES");
        return result;
    }
    public String getAge() throws Exception{
        String result = stringResult("AGE","PROFILES");
        return result;
    }
    public String getRelation() throws Exception{
        String result = stringResult("RELATIONSHIP_STATUS","PROFILES");
        return result;
    }
    public String getGender() throws Exception{
        String result = stringResult("GENDER","PROFILES");
        return result;
    }

}
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        String url = "jdbc:derby:xyz;create=true";
//        Connection connection = DriverManager.getConnection(url);
//        Statement statement = connection.createStatement();
//        String query = "SELECT USERNAME, GENDER FROM PROFILES";
//        ResultSet resultSet = statement.executeQuery(query);
//        while (resultSet.next()){
//            String userNames = resultSet.getString("USERNAME");
//            String firstNames = resultSet.getString("GENDER");
//            if (userNames.equals(currentUserName)){
//                result = firstNames;
//                break;
//            }