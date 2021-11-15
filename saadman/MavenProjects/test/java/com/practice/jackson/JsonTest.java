package com.practice.jackson;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class JsonTest {

    @Test
    void deserialized() throws IOException {
        JsonObj actual = new JsonObj();
        actual.setEventId("27521b29-b5db-4a8c-9d4b-1ff124f9f27bHabijabi");
        List<JsonObj> l=Json.deserialized(new File("D:\\Java Codes Intellij\\Learning Jackson\\Jackson\\src\\main\\java\\testFile.log"));

        /*ObjectMapper mapper = new ObjectMapper();
        BufferedReader read = new BufferedReader(new FileReader("D:\\Java Codes Intellij\\Learning Jackson\\Jackson\\src\\main\\java\\testFile.log"));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String def = read.readLine();

         */
        JsonObj test = l.get(0);

        assertEquals(test.eventId,actual.eventId);


    }

}