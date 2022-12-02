package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MatchForVoting implements IsSerializable {

    public String getUsername;

    public String username;
    public int rowId;
    public int matchID;
    public String gameType;
    public String groupStage;
    public String game;

    public String matchTime;
    public String team1;
    public String team2;
    public String venue;
    public String result;

    public MatchForVoting() {

    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }


    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGroupStage() {
        return groupStage;
    }

    public void setGroupStage(String groupStage) {
        this.groupStage = groupStage;
    }
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



}
