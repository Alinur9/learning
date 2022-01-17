package com.xyz.profiler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Helper {
    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM PICTURES";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            System.out.println("userName: " + rs.getString("USERNAME"));
//            System.out.println("EMAIL: "+rs.getString("EMAIL"));
//            System.out.println("PASSWORD: "+rs.getString("PASSWORD"));
            System.out.println(" ");
        }
        Database database = new Database();
        //       System.out.println(database.passwordCorrect("alinur","123"));
//      //  String query3 = "CREATE TABLE PICTURES (USERNAME VARCHAR(255), IMAGE BLOB)";
//    //    statement.execute(query3);
//        String query2 = "CREATE TABLE PROFILES (USERNAME VARCHAR(255),EMAIL VARCHAR(255),NAME VARCHAR(255)," +
//                " LASTNAME VARCHAR(255) ,OCCUPATION VARCHAR(255), COMPANY VARCHAR(255), " +
//                "AGE VARCHAR(255), RELATIONSHIP_STATUS  VARCHAR(255), GENDER VARCHAR(255))";
//        statement.execute(query2);
//    }
    }
}
