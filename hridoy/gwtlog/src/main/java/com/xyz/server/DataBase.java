package com.xyz.server;

import com.xyz.shared.MatchForVoting;
import com.xyz.tools.TimeZone;

import java.sql.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class DataBase {


    TimeZone timeZone = new TimeZone();


    Connection connection;

    private static final String SELECT_QUERY_OF_USER = "SELECT * FROM user_data WHERE username = ?";
    private static final String SELECT_QUERY1_FOR_INSERT = "INSERT INTO user_data" + "(username ,password,email)" + "VALUES (?,?,?)";
    String queryOfTvT = "SELECT * FROM team_vs_team";


    public DataBase() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cricket", "root", "Ahsan123@");
        }
        return connection;
    }
    PreparedStatement pst;
    public  ResultSet executeQuery (String data, String query) throws SQLException {

        connection = getConnection();
      pst = connection.prepareStatement(query);
        pst.setString(1, data);
        return pst.executeQuery();
    }

    public String getPwd(String username) throws SQLException {
        ResultSet resultSet = executeQuery(username,SELECT_QUERY_OF_USER);
        if (!resultSet.next())
            return null;
        return resultSet.getString("password");
    }

    public  long getMillis(String matchID) throws SQLException {

        ResultSet resultSet = executeQuery(matchID,"SELECT * FROM team_vs_team WHERE match_id = ?");
        pst.close();
        if (!resultSet.next())
            return Long.parseLong(null);
        return resultSet.getLong("millis");
    }

    public void signIn(String username, String password, String email) {

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY1_FOR_INSERT);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<MatchForVoting> getTvTList() throws SQLException {
        ArrayList<MatchForVoting> matchForVotingList = new ArrayList<>();
        connection = getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(queryOfTvT);


            ResultSet resultSet = pst.executeQuery();
            MatchForVoting matchForVoting;
            ZonedDateTime zdt = ZonedDateTime.now();
            long localTime = zdt.toInstant().toEpochMilli();
            System.out.println(localTime);
            while (resultSet.next()) {
                long millis = resultSet.getLong("millis");
                if (millis > localTime && millis - localTime <= 7200000L) {
                    matchForVoting = new MatchForVoting();
                    matchForVoting.setRowId(resultSet.getInt("id"));
                    matchForVoting.setMatchID(resultSet.getInt("match_id"));
                    matchForVoting.setGameType(resultSet.getString("gameType"));
                    matchForVoting.setGroupStage(resultSet.getString("groupStage"));
                    matchForVoting.setMatchTime(timeZone.getMatchTime(resultSet.getLong("millis")));
                    matchForVoting.setTeam1(resultSet.getString("team1"));
                    matchForVoting.setTeam2(resultSet.getString("team2"));
                    matchForVoting.setVenue(resultSet.getString("venue"));
                    matchForVoting.setResult(resultSet.getString("result"));

                    matchForVotingList.add(matchForVoting);
                }
            }
            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("dataBase checking" + "size of list : " + matchForVotingList.size());

        return matchForVotingList;
    }

    public  ArrayList<MatchForVoting> getUserTeamList(String username) throws SQLException{


        ArrayList<MatchForVoting> usersTeamList = new ArrayList<>();
        String query = "SELECT * FROM users_teams WHERE username = ?";
        try {

            ResultSet resultSet = executeQuery(username,query);
            pst.close();
            MatchForVoting matchForVoting;
            while (resultSet.next()) {
                matchForVoting = new MatchForVoting();

                matchForVoting.setMatchID(resultSet.getInt("match_id"));
                matchForVoting.setGroupStage(resultSet.getString("groupStage"));
                matchForVoting.setMatchTime(timeZone.getMatchTime(resultSet.getLong("millis")));
                matchForVoting.setGame(resultSet.getString("game"));
                matchForVoting.setTeam1(resultSet.getString("team"));
                matchForVoting.setResult(resultSet.getString("result"));

                usersTeamList.add(matchForVoting);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("in get userWinner Team");
        return usersTeamList;
    }

    public int checkVote(String username, String selectedTeam, String matchID) throws SQLException {

        ResultSet resultSet = executeQuery(username,"SELECT * FROM users_teams WHERE username = ?");
        pst.close();
        while (resultSet.next() && selectedTeam != null) {
            String checkMatchID = String.valueOf(resultSet.getInt("match_id"));
            String yourTeam = resultSet.getString("team");
            int idUser = resultSet.getInt("id");
            if (checkMatchID.equals(matchID) && yourTeam.equals(selectedTeam)) {
                return -1;
            } else if (checkMatchID.equals(matchID)) {
                updateTeam(selectedTeam,idUser);
                return idUser;
            }
        }
        return 0;
    }

    public void updateTeam(String updatedTeam, int idOfUser) {
        String queryOfUpdatedTeam = "UPDATE users_teams SET  team = '" + updatedTeam + "'  WHERE id = '" + idOfUser + "';";
        try {
            connection = getConnection();
            PreparedStatement pstUpdate = connection.prepareStatement(queryOfUpdatedTeam);
            pstUpdate.executeUpdate();
            pstUpdate.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  void insertVote(String username, String MID, String selectedTeam, String game, String gameType, String gStage) throws SQLException {
        connection = getConnection();
     PreparedStatement   pst = connection.prepareStatement("INSERT INTO users_teams " + "(username ,match_id,team,game,gameType,groupStage,millis)" + "VALUES (?,?,?,?,?,?,?)");
    long millis = getMillis(MID);
        pst.setString(1, username);
        pst.setString(2, MID);
        pst.setString(3, selectedTeam);
        pst.setString(4, game);
        pst.setString(5, gameType);
        pst.setString(6, gStage);
        pst.setLong(7, millis);

        pst.executeUpdate();
        pst.close();
    }

}
