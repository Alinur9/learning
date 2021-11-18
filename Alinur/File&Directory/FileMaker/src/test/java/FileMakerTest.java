import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileMakerTest {

    @Test
    void make() throws IOException {

        long fileLength = FileMaker.make("/home/alinur/IdeaProjects/Junit_Mockito/src" +
                "/test/resources/newTest.txt", 10);
        long actual = new File("/home/alinur/IdeaProjects/Junit_Mockito/src" +
                "/test/resources/newTest.txt").length();
        assertTrue(fileLength == actual);
    }
}