import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileMakerTest {

    @Test
    void make() throws IOException {

        long filesToMake = FileMaker.make("/home/alinur/IdeaProjects/Junit_Mockito/src" +
                "/test/resources/newTest.txt", 1000);
        long actual = 1;
        assertTrue(filesToMake== actual);
    }
    @Test
    void makeTree() throws IOException {
        int filesToMake = FileMaker.makeTree("/home/alinur/IdeaProjects/Junit_Mockito/src/" +
                "test/resources/TestTree",15,150);
        int actual = 150;
        assertTrue(filesToMake == actual);
    }
}