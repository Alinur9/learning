import junit.framework.TestCase;

import java.util.List;

public class DataBaseTest extends TestCase {

    public void testGetColumnNames() {
        String a = "Name varchar(40), Salary int, Age int";
        DataBase dataBase = new DataBase();
        List arr = dataBase.getColumnNames(a);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public void testShowTable() throws Exception {
        String databaseName = "xyz";
        String tableName = "kebla";
        DataBase dataBase = new DataBase();
   //     dataBase.createTable(databaseName,tableName,"Name varchar(40), salary int");
        String s = dataBase.showTable(tableName);
        System.out.println(s);
    }

    public void testShowColumn() {

    }
}