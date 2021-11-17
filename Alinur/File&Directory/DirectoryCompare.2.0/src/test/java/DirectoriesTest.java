import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DirectoriesTest {

    @Test
    void compare() throws IOException {
        Directories.put("/home/alinur/IdeaProjects/Junit_Mockito/Test Folder/4",
                "/home/alinur/IdeaProjects/Junit_Mockito/Test Folder/5");
        Log log = Mockito.mock(Log.class);
     Directories.compare(log);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(log, times(1)).print(captor.capture());

// Assert the argument
        String actual = captor.getValue();
        assertEquals("The Directories are same!", actual);
    }
}