import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    HashMap columnNames = new HashMap<>();
    public  void createTable (String tableName,String defineTable)throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE " + tableName + "(Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                + defineTable + ")";
        statement.execute(query);
        System.out.println("Table Created");
        columnNames.put(tableName,defineTable);
    }
    public  void insertIntoTable(String tableName, String insertString)throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "INSERT INTO " + tableName + "(" + insertString + ")";
        statement.execute(query);
        System.out.println("Inserted into Table");
    }
    public String showColumn(String tableName){
        List arr = getColumnNames(tableName);
        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            result += arr.get(i);
            result += " ,";
        }
        return result;
    }
    public  String showTable(String tableName) throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String url = "jdbc:derby:xyz;create=true" ;
        Connection connection  = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(query);
        String result = "";
        List columnNames = getColumnNames(tableName);
        int i = 0;
        while (resultSet.next()){
            result += resultSet.getString(i);
            result += "\n";
            i++;
        }
        return result;
    }
    public List getColumnNames(String tableName){
        columnNames.put("cheker",12);
       String rawColumnNames = (String) columnNames.get(tableName);
        List columnNameArr = new ArrayList<>();
        List finalColumnNameArr = new ArrayList<>();
        String column = "";
        for (int i = 0; i < rawColumnNames.length(); i++) {
            char c = rawColumnNames.charAt(i);
            if (c == ','){
                columnNameArr.add(column);
                column = "";
            }
            else {
                column += c;
            }
        }
        if (!column.equals(""))
        columnNameArr.add(column);
        for (int i = 0; i < columnNameArr.size(); i++) {
            String s = (String) columnNameArr.get(i);
            String columnName = "";
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == ' ' && j ==0)
                    continue;
                if (c == ' '){
                    finalColumnNameArr.add(columnName);
                    break;
                }else {
                    columnName += c;
                }
            }
        }
        return finalColumnNameArr;
    }

}
