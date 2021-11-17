import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompareFiles {
    String filePath1, filePath2;

    CompareFiles(String filepath1, String filepath2) {
        this.filePath1 = filepath1;
        this.filePath2 = filepath2;
    }

    public boolean compare() throws IOException {
        BufferedReader fileReader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(filePath2));
        int i=1,j=1;
        String file1="";
        String file2 ="";
        while(i!=-1)
        {
            file1+=fileReader1.readLine();
            i=fileReader1.read();

        }
        while( j!=-1)
        {

            file2+=fileReader2.readLine();
            j = fileReader2.read();

        }
        if(file1.equals(file2))
        {

            return true;
        }
       return false;
    }
}