package com.practice.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static List deserialized(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String def = "";
        List<JsonObj> list = new ArrayList();
        while((def=reader.readLine())!=null)
        {
            JsonObj obj = mapper.readValue(def,JsonObj.class);
            list.add(obj);
        }
        return list;
    }

}
