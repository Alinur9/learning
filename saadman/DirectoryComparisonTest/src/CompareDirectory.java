import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareDirectory {
    String directoryPath1,directoryPath2;
    ArrayList<String> directoryFiles1,directoryFiles2,filePath1,filePath2;
    CompareDirectory(String dicrectoryPath1,String directoryPath2){
        this.directoryPath1=dicrectoryPath1;
        this.directoryPath2=directoryPath2;
    }
    public boolean compare(Log log) throws IOException {
        File directory1 = new File(directoryPath1);
        File directory2 = new File(directoryPath2);
        this.directoryFiles1 = new ArrayList<>();
        this.directoryFiles2 = new ArrayList<>();
        this.filePath1 = new ArrayList<>();
        this.filePath2 = new ArrayList<>();
        traverseDirectory(directory1,directoryFiles1,filePath1);
        traverseDirectory(directory2,directoryFiles2,filePath2);
        if(!compareInnerDirectories(directoryFiles1,directoryFiles2))
        {
            log.print("Directories are not same.");
            return false;
        }
        if(filePath1.size() == filePath2.size())
        {
            for(int i=0;i<filePath1.size();i++)
            {
                CompareFiles c1 = new CompareFiles(filePath1.get(i),filePath2.get(i));
                if(!c1.compare())
                {
                    log.print("Directory are not same");
                    return false;
                }
            }
        }
        System.out.println("Directory are same.");
        return true;
    }
    public boolean compareInnerDirectories(ArrayList<String> directoryFiles1,ArrayList<String> directoryFiles2) throws IOException {
        if(directoryFiles1.size()==directoryFiles2.size())
        {
            for(int i=0;i<directoryFiles1.size();i++)
            {
                String temp1 = directoryFiles1.get(i).substring(directoryPath1.length());
                String temp2 = directoryFiles2.get(i).substring(directoryPath2.length());
                if(!(temp1.equals(temp2)))
                {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
    public void traverseDirectory(File directory, ArrayList<String> directoryPath, ArrayList<String> filePath)
    {
        if(directory.isDirectory())
        {
            File[] childDirectory = directory.listFiles();
            for(File child : childDirectory)
            {
                directoryPath.add(child.getAbsolutePath());
                if(child.isDirectory())
                {
                    traverseDirectory(child,directoryPath,filePath);
                }
                else
                {
                    filePath.add(child.getAbsolutePath());
                }
            }
        }
    }
}
