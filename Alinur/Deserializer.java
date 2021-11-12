import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.LinkedList;

public class Deserializer {

    public static void main(String[] args) throws IOException {
        File log = new File("/home/alinur/IdeaProjects/Log/src/main/application.log");
        LinkedList<Log> logs =  deserialized(log);

        for (int i = 0; i < 10; i++) {
            Log log1 = logs.get(i);
            System.out.println(log1.eventId);
            System.out.println(log1.payload.jobSize);
        }


    }
    public static LinkedList<Log> deserialized(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File logFile = file;
        BufferedReader reader = new BufferedReader( new FileReader(logFile));
        String currentLine = "";
        LinkedList<Log> logs = new LinkedList<>();
        while ((currentLine = reader.readLine()) != null){
            Log currentLog = mapper.readValue(currentLine,Log.class);
            logs.add(currentLog);
        }
 //     Log currentLog = mapper.readValue(new FileInputStream(file),Log.class);
//        logs.add(currentLog);
        return logs;
    }
}
