package com.google.gwt.user.client.rpc.core.java.util.concurrent;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RejectedExecutionException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, java.util.concurrent.RejectedExecutionException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static java.util.concurrent.RejectedExecutionException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new java.util.concurrent.RejectedExecutionException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.util.concurrent.RejectedExecutionException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.java.util.concurrent.RejectedExecutionException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.util.concurrent.RejectedExecutionException_FieldSerializer.deserialize(reader, (java.util.concurrent.RejectedExecutionException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.util.concurrent.RejectedExecutionException_FieldSerializer.serialize(writer, (java.util.concurrent.RejectedExecutionException)object);
  }
  
}
