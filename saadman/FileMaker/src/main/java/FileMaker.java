import java.io.*;

public class FileMaker {
    public String makeDirectory(String path) throws IOException {
            File file = new File(path);
            file.mkdir();
            return file.getName();
    }
    public File writeFile(String path, long size) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        long n = 0;
        for(int i=0;i<size;i++) {
            for (int j = 0; j <= 80500; j++)
                writer.write("JAVA IS FUN!\n");
        }
        writer.flush();
        writer.close();
        return new File(path);
    }
    public long makeMultiplayFiles(String path,long numberOfFiles,long fileSize) throws IOException {
        File file = new File(path);
        file.mkdir();
        char folderName = 65;
        int fileName = 1;
        long folderCount =numberOfFiles/10;
        long fileCount = 0;
        String slash = "\\";

        for(int i=0;i<folderCount;i++)
        {
            if(folderName==91)folderName=65;
            String pathName = path+slash+folderName+i;
            File file1 = new File(pathName);
            file1.mkdir();
            for(int j=0;j<10;j++)
            {
                String filePath = pathName+slash+fileName+".txt";
                writeFile(filePath,fileSize);
                fileName++;
                fileCount++;
            }
            folderName++;
        }
        long remaining = numberOfFiles-fileCount;
        String pathName = path+slash+folderName;
        if(remaining==0)return folderCount;
        File file1 = new File(pathName);
        file1.mkdir();
        for(int i =0;i<remaining;i++)
        {
            String filePath =pathName+slash+fileName+".txt";
            writeFile(filePath,fileSize);
            fileName++;
        }
        return folderCount;
    }
    public String copyFile(String inputPath, String outputPath) throws IOException {



        if(outputPath.charAt(outputPath.length()-1)!=92)outputPath+='\\';
        outputPath+="CopyOf_";
        int flag=0;
        for(int i=inputPath.length()-1;i>0;i--)
        {
            char a = inputPath.charAt(i);
           if(a==92)
           {
               flag=i;
               break;
           }
        }
        for(int i=flag+1;i<inputPath.length();i++)
        {
            outputPath+=inputPath.charAt(i);
        }

        FileInputStream is = new FileInputStream(inputPath);
        byte[] data = new byte[8*1024];
        FileOutputStream os = new FileOutputStream(outputPath);
        int read;
        while((read = is.read(data)) !=-1)
        {
            os.write(data);
        }
        is.close();
        os.close();
        File file = new File(outputPath);
        return file.getName();
    }


}
