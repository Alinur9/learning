package com.xyz.filemaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Directories {
    static String[] testPaths;
    static ArrayList<String> paths = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> filePaths = new ArrayList<>();
    static boolean test = false;

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
                paths.add(child.getAbsolutePath());
                if (child.isDirectory())
                    listPaths(child);
            }
        }
        return paths;
    }
    private static ArrayList<String> listFilePaths(File file1) throws IOException {
        boolean checkDirectory = file1.isDirectory();
        if (checkDirectory) {
            File[] children = file1.listFiles();
            for (File child : children) {
                if (child.isDirectory())
                    listFilePaths(child);
                else
                    filePaths.add(child.getAbsolutePath());
            }
        }
        return filePaths;
    }
    private static String getNeededPaths(File file1) throws IOException {
        paths = new ArrayList<>();
        ArrayList<String> fullPaths = listPaths(file1);
        String parentPath = file1.getAbsolutePath();
        String neededPaths = "";
        for (String path : fullPaths) {
            neededPaths += path.substring(parentPath.length());
        }
        return neededPaths;
    }

    private static int fileCompare(File file1,File file2) throws IOException{
        Log log = new Log();
        System.out.println("Comparing two Files!....\n");
        if (file1.length() != file2.length()) {
            log.print("The Directories are not same!");
            return 0;
        }
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1),bufferSize);
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2),bufferSize);
        int read1;
        int read2;
        boolean same = true;
        while ((read1 = bufferedReader1.read()) != -1) {
            read2 = bufferedReader2.read();
            if (read1 != read2) {
                same = false;
                bufferedReader1.close();
                bufferedReader2.close();
                break;
            }
        }
        if (same) {
            log.print("The Files are  same!");
            return 1;
        } else {
            log.print("The Files are not same!");
            return 0;
        }
    }
    private static int dirCompare(ArrayList<String> paths1, ArrayList<String> paths2) throws IOException {
        Log log = new Log();
        boolean sameFiles = true;
        for (int i = 0; i < paths1.size(); i++){
            File file1 = new File(paths1.get(i));
            File file2 = new File(paths2.get(i));

            int bufferSize = 32 * 1024;
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1),bufferSize);
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2),bufferSize);
            int read1, read2;
            while ((read1 = bufferedReader1.read()) != -1) {
                read2 = bufferedReader2.read();
                if (read1 != read2) {
                    sameFiles = false;
                    bufferedReader1.close();
                    bufferedReader2.close();
                    break;
                }
            }
        }
        if (sameFiles) {
            log.print("The Directories are same!");
            return 1;
        } else {
            log.print("The Directories are not same!");
            return 0;
        }
    }
    private static String getPath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide File/Directories path:-");
        String path1 = scanner.nextLine();
        return path1;
    }
    public static int compare(String path1,String path2) throws IOException {
        Log log = new Log();
        File file2,file1;
        file1 = new File(path1);
        file2 = new File(path2);
        boolean checkType1 = file1.isDirectory();
        boolean checkType2 = file2.isDirectory();
        System.out.println("\nChecking File/Directory types..");
        if (checkType1 != checkType2) {
            log.print("The Directories are not same!");
            return 0;
        }
        if (checkType1 && checkType2) {
            System.out.println("Comparing Two Directories.... \n");
            String p1 = getNeededPaths(file1);
            String p2 = getNeededPaths(file2);
            if (!p1.equals(p2)) {
                log.print("The Directories are not same!");
                return 0;
            }
            paths = new ArrayList<>();
            ArrayList<String> paths1 = listPaths(file1);
            paths = new ArrayList<>();
            ArrayList<String> paths2 = listPaths(file2);
            ArrayList<String> filePaths1 = listFilePaths(file1);
            filePaths = new ArrayList<>();
            ArrayList<String> filPaths2 = listFilePaths(file2);
            int len1 = paths1.size();
            int len2 = paths2.size();
            if (len1 != len2) {
                log.print("The Directories are not same!");
                return 0;
            }
            int ret = dirCompare(filePaths1,filPaths2);
            return ret;
        }
        else {
            int ret = fileCompare(file1, file2);
            return ret;
        }
    }
}
class Log {
    void print(String message){
        System.out.println(message);
    }
}
