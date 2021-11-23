
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FileMakerTest {
    FileMaker m = new FileMaker();
   @BeforeEach
   void setUp() throws IOException {

   }

  @Test

   void makeDirectory() throws IOException {
       FileMaker mockFileMaker = Mockito.mock(FileMaker.class);
      doThrow(IOException.class).when(mockFileMaker).makeDirectory("D:\\directorytest");
       String expected = "directorytest";
      String actual = mockFileMaker.makeDirectory("D:\\directorytest");
       assertEquals(expected,actual,"IO Exception Found");

    }
    @Test
    void multipleFiles() throws IOException {

        m.makeMultiplayFiles("D:\\test",1000,1);
    }

    @Test
    void copyFile() throws IOException {
        m.copyFile("D:\\TestFolder\\","D:\\TestFolder\\");
    }
}