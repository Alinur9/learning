package com.xyz.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class VotingResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.xyz.shared.VotingResponse instance) throws SerializationException {
    instance.errorMsg = streamReader.readString();
    instance.successful = streamReader.readBoolean();
    instance.username = streamReader.readString();
    
  }
  
  public static com.xyz.shared.VotingResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.xyz.shared.VotingResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.xyz.shared.VotingResponse instance) throws SerializationException {
    streamWriter.writeString(instance.errorMsg);
    streamWriter.writeBoolean(instance.successful);
    streamWriter.writeString(instance.username);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.xyz.shared.VotingResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.xyz.shared.VotingResponse_FieldSerializer.deserialize(reader, (com.xyz.shared.VotingResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.xyz.shared.VotingResponse_FieldSerializer.serialize(writer, (com.xyz.shared.VotingResponse)object);
  }
  
}
