package com.example.worldc;

import java.util.Date;

public class Record_TvT {
    private String groupStage;
private String gameType;
private int  match_id;
private String team1;
private String team2;
private String date;
private String tom;
private String venue;
private String result;
private int id;
    public Record_TvT(int id, String gameType, int match_id, String team1, String date , String tom, String team2, String venue, String result,String groupStage) {
        this.groupStage = groupStage;
        this.gameType = gameType;
        this.match_id=match_id;
        this.team1 = team1;
        this.date = date ;
        this.tom = tom;
        this.team2 = team2;
        this.venue = venue;
        this.result = result;
        this.id= id;
    }
    public int getId(){
        return id;
    }
    public String getGameType(){
        return gameType;
    }
    public String getGroupStage(){return groupStage;}
    public int getMatch_id(){
        return match_id;
    }
    public String getDate(){return  date;}
    public String getTom() {
        return tom;
    }
    public String getTeam1() {
        return team1;
    }
    public String getTeam2() {
        return team2;
    }
   public String getVenue(){
        return venue;
   }
   public String getResult() {return result;}
}
