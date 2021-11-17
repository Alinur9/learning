import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Directories {
    static String[] testPaths;
    static ArrayList<String> paths = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static boolean test = false;
    private static ArrayList<String> listNames(File file1) throws IOException {
        boolean checkDirectory = file1.isDirectory();
        if (checkDirectory){
            File[] children = file1.listFiles();
            for (File child : children){
                if (child.isDirectory())
                    listNames(child);
                else
                    names.add(child.getName() + ",");
            }
            Collections.sort(names);
        }
        return names;
    }
    static String[] put(String path1, String path2){
        test = true;
        testPaths = new String[]{path1, path2};
        return testPaths;
    }

    private static ArrayList<String> listPaths(File file1) throws IOException {
        boolean checkDirectory = file1.isDirectory();
        if (checkDirectory) {
            File[] children = file1.listFiles();
            for (File child : children) {
                if (child.isDirectory())
                    listPaths(child);
                else
                    paths.add(child.getAbsolutePath());
            }
        }
        return paths;
    }
    private static String getNeededPaths(File file1) throws IOException {
       ArrayList<String> fullPaths = listPaths(file1);
       String parentPath = file1.getAbsolutePath();
       String neededPaths = "";
        for (String path : fullPaths) {
            neededPaths += path.substring(parentPath.length()-1);
        }
        return neededPaths;
    }
    private static String getNames(String path) throws IOException {
        String allNames = "";
        File file1 = new File(path);
        ArrayList<String> names = listNames(file1);
        for (String name : names){
            allNames += names;
        }
        return allNames;
    }
    private static void fileCompare(File file1,File file2) throws IOException{
        System.out.println("Comparing two Files!....\n");
        if (file1.length() != file2.length()) {
            System.out.println("The Files are not same!");
            return;
        }
        InputStream stream1 = new FileInputStream(file1);
        InputStream stream2 = new FileInputStream(file2);
        int read1;
        int read2;
        boolean same = true;
        while ((read1 = stream1.read()) != -1) {
            read2 = stream2.read();
            if (read1 != read2) {
                same = false;
                stream1.close();
                stream2.close();
                break;
            }
        }
        if (same)
            System.out.println("The Files are same!");
        else
            System.out.println("The files are not same!");
    }
    private static void dirCompare(ArrayList<String> paths1, ArrayList<String> paths2) throws IOException {
        boolean sameFiles = true;
        for (int i = 0; i < paths1.size(); i++){
            File file1 = new File(paths1.get(i));
            File file2 = new File(paths2.get(i));
            InputStream stream1 = new FileInputStream(file1);
            InputStream stream2 = new FileInputStream(file2);
            int read1, read2;
            while ((read1 = stream1.read()) != -1) {
                read2 = stream2.read();
                if (read1 != read2) {
                    sameFiles = false;
                    stream1.close();
                    stream2.close();
                    break;
                }
            }
        }
        if (sameFiles) {
            System.out.println("The Directories are same!");
        } else {
            System.out.println("The Directories are not same!");
        }
    }
    private static String getPath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide File/Directories path:-");
        String path1 = scanner.nextLine();
        return path1;
    }
    public static void compare() throws IOException {
        File file2,file1;
        String path2,path1;
        if (test) {
            String[] paths = testPaths;
            path1 = testPaths[0];
            path2 = testPaths[1];
        }else {
            path1 = getPath();
            path2 = getPath();
        }
        file1 = new File(path1);
        file2 = new File(path2);
        boolean checkType1 = file1.isDirectory();
        boolean checkType2 = file2.isDirectory();
        System.out.println("\nChecking File/Directory types..");
        if (checkType1 != checkType2) {
            System.out.println("The File/Directory types are not same!");
            return;
        }
        if (checkType1 && checkType2) {
            System.out.println("Comparing Two Directories.... \n");
            String s1 = getNames(path1);
            String s2 = getNames(path2);
            if (!s1.equals(s2)) {
                System.out.println("The Directories not same!");
                return;
            }
            String p1 = getNeededPaths(file1);
            String p2 = getNeededPaths(file2);
            if (!p1.equals(p2)) {
                System.out.println("The Directories not same!");
                return;
            }
            ArrayList<String> paths1 = listPaths(file1);
            ArrayList<String> paths2 = listPaths(file2);
            int len1 = paths1.size();
            int len2 = paths2.size();
            if (len1 != len2) {
                System.out.println("The Directories are not same!");
                return;
            }
            dirCompare(paths1,paths2);
        }
        else
            fileCompare(file1,file2);
    }
}
