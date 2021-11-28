import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileMakerTest {

    FileMakerTest(){
    }
    String path;
    int sizeMb;
    int fileCount;

    @Test
    void makeTree() throws IOException {
        path = "/home/alinur/IdeaProjects/Junit_Mockito/src" +
                "/test/resources/TestTree1.txt";
        sizeMb = 1;
        fileCount = 1000;
        int actual = FileMaker.makeTree(path,sizeMb,fileCount);
        int expected = FileMaker.leafCount(new File(path));
        assertEquals(expected,actual);
    }

    @AfterEach
    void clear(){
        FileMaker.clear( new File(path));
    }

}
//    @Test
//    void make() throws IOException {
//
//        long filesToMake = FileMaker.make(path, 1000);
//        long actual = 1;
//        assertTrue(filesToMake== actual);
//    }