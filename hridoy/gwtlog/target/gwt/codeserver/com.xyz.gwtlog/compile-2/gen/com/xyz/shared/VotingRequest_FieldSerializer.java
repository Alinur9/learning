package com.xyz.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class VotingRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.xyz.shared.VotingRequest instance) throws SerializationException {
    instance.game = streamReader.readString();
    instance.gameType = streamReader.readString();
    instance.groupStage = streamReader.readString();
    instance.matchID = streamReader.readInt();
    instance.selectedTeam = streamReader.readString();
    instance.team1 = streamReader.readString();
    instance.team2 = streamReader.readString();
    instance.time = streamReader.readString();
    instance.user = streamReader.readString();
    
  }
  
  public static com.xyz.shared.VotingRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.xyz.shared.VotingRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.xyz.shared.VotingRequest instance) throws SerializationException {
    streamWriter.writeString(instance.game);
    streamWriter.writeString(instance.gameType);
    streamWriter.writeString(instance.groupStage);
    streamWriter.writeInt(instance.matchID);
    streamWriter.writeString(instance.selectedTeam);
    streamWriter.writeString(instance.team1);
    streamWriter.writeString(instance.team2);
    streamWriter.writeString(instance.time);
    streamWriter.writeString(instance.user);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.xyz.shared.VotingRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.xyz.shared.VotingRequest_FieldSerializer.deserialize(reader, (com.xyz.shared.VotingRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.xyz.shared.VotingRequest_FieldSerializer.serialize(writer, (com.xyz.shared.VotingRequest)object);
  }
  
}
