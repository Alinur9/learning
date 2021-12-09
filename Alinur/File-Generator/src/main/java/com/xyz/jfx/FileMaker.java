package com.xyz.jfx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMaker {
    private static String path;
    private static File fileTodlt;
    private static int fileCount;

    private static char[] characters(){
        char[] characters = new char[32001];
        char character = 0;
        for (int i = 0; i <= 32000; i++) {
            characters[i] = character;
            character++;
            if (character == 127)
                character = 0;
        }
        return characters;
    }
    public static long make (String path, long sizeMB) throws IOException {
        int successFiles = 0;
        long mbToLong = (long) (sizeMB*31.25);
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter( new FileWriter(file));
        char[] chars = characters();//char[] chars = {'T','h','i','s',' ','I','s',' ','A',' ','T','e','s','t'};
        for (int i = 0; i <= mbToLong; i++)
            writer.write(chars);
        writer.flush();
        writer.close();
        System.out.println("File of " + sizeMB + " megabytes created successfully!");
        successFiles++;
        //  return file.length();
        return successFiles;
    }
    public static long  makeDirectory(String path, long sizeMb,int fileCount) throws IOException{
        int successFiles = 0;
        File directory = new File(path);
        directory.mkdir();
        Integer fileName = 1;
        for (int i = 0; i < fileCount; i++) {
            String fileNameStr = fileName.toString();
            successFiles += make(path+ "/" +fileNameStr,sizeMb);
            fileName++;
        }
        return successFiles;
    }
    public static int makeTree(String path, long sizeMb, int fileCount) throws IOException {
        FileMaker.path = path;
        int successFiles = 0;
        File root = new File(path);
        boolean is30 = false;
        int branchCount = 0;
        if (fileCount < 32)
            branchCount = (fileCount/2);
        else {
            branchCount = fileCount / 30;
            is30 = true;
        }
        root.mkdir();
        Integer dirName = 1;
        for (int i = 0; i < branchCount; i++) {
            String dirNameStr = dirName.toString();
            File fileForDir = new File(path + "/" + dirNameStr);
            if (is30) {
                successFiles += makeDirectory(path + "/" + dirNameStr, sizeMb, 30);
            } else
                successFiles += makeDirectory(path + "/" + dirNameStr, sizeMb, 2);
            dirName++;
        }
        fileTodlt = new File(FileMaker.path);
        successFiles += remainingFiles(is30,dirName,branchCount,fileCount,path,sizeMb);
        return successFiles;
    }
    private static long remainingFiles(boolean is30,Integer dirName,int branchCount,
                                       int fileCount,String path,long sizeMb) throws IOException{
        int successFiles = 0;
        int remainingFiles = 0;
        if (is30) {
            remainingFiles = fileCount - (branchCount * 30);
            String dirNameStr = dirName.toString();
            File fileForDir = new File(path + "/" + dirNameStr);
            successFiles += makeDirectory(path + "/" + dirNameStr, sizeMb, remainingFiles);
        }
        else {
            remainingFiles = fileCount - (branchCount * 2);
            String dirNameStr = dirName.toString();
            File fileForDir = new File(path + "/" + dirNameStr);
            successFiles += makeDirectory(path + "/" + dirNameStr, sizeMb, remainingFiles);
        }
        return successFiles;
    }
    static void clear(File file){
        if (file.isDirectory()){
            for (File f : file.listFiles())
                FileMaker.clear(f);
        }
        file.delete();
    }
    static int leafCount(File tree){
        if (tree.isDirectory()) {
            File[] fileArr = tree.listFiles();
            int len = fileArr.length;
            for (int i = 0; i < len; i++) {
                File file1 = fileArr[i];
                if (file1.isDirectory())
                    leafCount(file1);
                else
                    fileCount++;
            }
        }
        else
            fileCount++;
        return fileCount;
    }
}
