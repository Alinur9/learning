package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class VotingRequest implements IsSerializable {

    public String user;
    public int matchID;
    public String team1;
    public String team2;
    public String selectedTeam;
    public String gameType;
    public String groupStage;

    public String game;

    public String time;

}
