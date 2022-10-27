package com.example.worldc;

import java.util.Date;

public class RecordUsersTeam {
    private String gameTypeUT;
    private String groupStageUT;
    private String game;
    private String team;
    private String date;
    private String tom;
    private String result ;
    private int id;
    private int  match_id;





    public RecordUsersTeam(int id, String gameType, String game, int match_id, String team, String date , String tom, String result,String groupStageUT) {
        this.gameTypeUT = gameType;
        this.groupStageUT = groupStageUT;
        this.game = game;
        this.team = team;
        this.date = date;
        this.tom = tom;
        this.result = result;
        this.id= id;
        this.match_id=match_id;
    }
    public String getGameType(){return gameTypeUT;}
    public String getGroupStageUT(){return groupStageUT;}
    public String getGame() {
        return game;
    }
    public String getTeam() {
        return team;
    }
    public String getDate(){return  date;}
    public String getTom() {
        return tom;
    }
    public String getResult() { return result;}
    public int getId(){
        return id;
    }
    public int getMatch_id(){
        return match_id;
    }

}
