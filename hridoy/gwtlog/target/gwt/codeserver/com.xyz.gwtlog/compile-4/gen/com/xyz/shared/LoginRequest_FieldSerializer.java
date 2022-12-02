package com.xyz.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.xyz.shared.LoginRequest instance) throws SerializationException {
    instance.email = streamReader.readString();
    instance.password = streamReader.readString();
    instance.username = streamReader.readString();
    
  }
  
  public static com.xyz.shared.LoginRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.xyz.shared.LoginRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.xyz.shared.LoginRequest instance) throws SerializationException {
    streamWriter.writeString(instance.email);
    streamWriter.writeString(instance.password);
    streamWriter.writeString(instance.username);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.xyz.shared.LoginRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.xyz.shared.LoginRequest_FieldSerializer.deserialize(reader, (com.xyz.shared.LoginRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.xyz.shared.LoginRequest_FieldSerializer.serialize(writer, (com.xyz.shared.LoginRequest)object);
  }
  
}
