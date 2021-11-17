import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
class CompareDirectoryTest {
    CompareDirectory com;
    void setUp(){

    }
    @Test
    void compare() throws IOException {
        com = new CompareDirectory("D:\\Java Codes Intellij\\JUnit1\\Junit\\src\\test\\Test Folder\\5","D:\\Java Codes Intellij\\JUnit1\\Junit\\src\\test\\Test Folder\\4");
        Log log = Mockito.mock(Log.class);
        com.compare(log);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(log, times(1)).print(captor.capture());
        String actual = captor.getValue();
        assertEquals("Directories are not same.",actual);
    }
}