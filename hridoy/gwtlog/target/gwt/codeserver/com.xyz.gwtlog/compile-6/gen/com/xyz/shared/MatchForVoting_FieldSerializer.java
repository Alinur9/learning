package com.xyz.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MatchForVoting_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.xyz.shared.MatchForVoting instance) throws SerializationException {
    instance.game = streamReader.readString();
    instance.gameType = streamReader.readString();
    instance.getUsername = streamReader.readString();
    instance.groupStage = streamReader.readString();
    instance.matchID = streamReader.readInt();
    instance.matchTime = streamReader.readString();
    instance.result = streamReader.readString();
    instance.rowId = streamReader.readInt();
    instance.team1 = streamReader.readString();
    instance.team2 = streamReader.readString();
    instance.username = streamReader.readString();
    instance.venue = streamReader.readString();
    
  }
  
  public static com.xyz.shared.MatchForVoting instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.xyz.shared.MatchForVoting();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.xyz.shared.MatchForVoting instance) throws SerializationException {
    streamWriter.writeString(instance.game);
    streamWriter.writeString(instance.gameType);
    streamWriter.writeString(instance.getUsername);
    streamWriter.writeString(instance.groupStage);
    streamWriter.writeInt(instance.matchID);
    streamWriter.writeString(instance.matchTime);
    streamWriter.writeString(instance.result);
    streamWriter.writeInt(instance.rowId);
    streamWriter.writeString(instance.team1);
    streamWriter.writeString(instance.team2);
    streamWriter.writeString(instance.username);
    streamWriter.writeString(instance.venue);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.xyz.shared.MatchForVoting_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.xyz.shared.MatchForVoting_FieldSerializer.deserialize(reader, (com.xyz.shared.MatchForVoting)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.xyz.shared.MatchForVoting_FieldSerializer.serialize(writer, (com.xyz.shared.MatchForVoting)object);
  }
  
}
