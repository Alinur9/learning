package com.xyz.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.xyz.shared.LoginResponse instance) throws SerializationException {
    instance.errorMsg = streamReader.readString();
    instance.successful = streamReader.readBoolean();
    
  }
  
  public static com.xyz.shared.LoginResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.xyz.shared.LoginResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.xyz.shared.LoginResponse instance) throws SerializationException {
    streamWriter.writeString(instance.errorMsg);
    streamWriter.writeBoolean(instance.successful);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.xyz.shared.LoginResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.xyz.shared.LoginResponse_FieldSerializer.deserialize(reader, (com.xyz.shared.LoginResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.xyz.shared.LoginResponse_FieldSerializer.serialize(writer, (com.xyz.shared.LoginResponse)object);
  }
  
}
