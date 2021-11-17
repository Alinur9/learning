import java.io.File;
import java.io.IOException;

public class ComareFilesDriver {
    public static void main(String[] args) throws IOException {
        CompareFiles c1 = new CompareFiles("D:\\Java Codes Intellij\\JUnit1\\src\\Test Folder\\1\\11\\111 text.txt","D:\\Java Codes Intellij\\JUnit1\\src\\Test Folder\\1\\12\\12 text .txt");
        System.out.println(c1.compare());
        CompareDirectory c2 = new CompareDirectory("D:\\Java Codes Intellij\\JUnit1\\src\\Test Folder\\4","D:\\Java Codes Intellij\\JUnit1\\src\\Test Folder\\5");

    }
}
