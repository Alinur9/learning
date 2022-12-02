package com.xyz.server;

import com.xyz.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.xyz.client.LoginUi;
import com.xyz.shared.*;

import java.sql.SQLException;
import java.util.*;

//server
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

  String username;
  DataBase dataBase = new DataBase();
  User user = new User();
  @Override
  public String greetServer(String input) throws IllegalArgumentException {
    if (!FieldVerifier.isValidName(input)) {
      // If the input is not valid, throw an IllegalArgumentException back to
      // the client.
      throw new IllegalArgumentException(
              "Name must be at least 4 characters long");
    }
    String serverInfo = getServletContext().getServerInfo();
    String userAgent = getThreadLocalRequest().getHeader("User-Agent");

    // Escape data from the client to avoid cross-site script vulnerabilities.
    input = escapeHtml(input);
    userAgent = escapeHtml(userAgent);
    return "Hello, " + input + "!<br><br>I am running " + serverInfo
            + ".<br><br>It looks lik e you are using:<br>" + userAgent;
  }

  @Override
  public LoginResponse login(LoginRequest request) throws RuntimeException {
    System.out.println("Checking  database Or keeping in memory..... ???  ");

    try {
      username =request.username;
      user.username = request.username;
      user.password = dataBase.getPwd(request.username);
    } catch (SQLException e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
      throw new RuntimeException(e);
    }
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.successful  = true;
    loginResponse.setUsername(request.username);

    if(user.password == null) {
      loginResponse.successful = false;
      loginResponse.errorMsg = "No user found";
    } else if (!user.password.equals(request.password)) {
      loginResponse.successful= false;
      loginResponse.errorMsg = "Wrong password";
    }
    return loginResponse;
  }

  public LoginResponse signup(LoginRequest request) throws RuntimeException {
    LoginResponse response = new LoginResponse();
    response.successful = true;
    try {
     user.password = dataBase.getPwd(request.username);
      if (user.password != null){
        response.successful = false;
        response.errorMsg = "this username already exist";
      }else {
        dataBase.signIn(request.username,request.password, request.email);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }


    return response;
  }

  @Override
  public ArrayList<MatchForVoting> getMatchesForVoting() throws RuntimeException {
    try {

      return dataBase.getTvTList();
    } catch (SQLException e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
      throw new RuntimeException(e);
    }
  }
@Override
  public ArrayList<MatchForVoting> getUsersWinnerTeam() throws RuntimeException{

  System.out.println();
  try {
    return dataBase.getUserTeamList("ahsan");
  } catch (SQLException e) {
    System.out.println(Arrays.toString(e.getStackTrace()));
    throw new RuntimeException(e);
  }
}

  @Override
  public VotingResponse votedTeam(VotingRequest votingRequest)throws RuntimeException{

    VotingResponse votingResponse = new VotingResponse();
    System.out.println(votingRequest.user);
    String team = votingRequest.selectedTeam;
    votingResponse.successful = true;
    int isVoted;
    String matchID = String.valueOf(votingRequest.matchID);
    try {
       isVoted = dataBase.checkVote(user.username,team,matchID);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
      if (isVoted == -1 ){
  votingResponse.successful = false;
  votingResponse.errorMsg = "you already voted on this team";
    } else if (isVoted != 0 ) {
  votingResponse.successful = false;
  votingResponse.errorMsg = "your selected team updated on previous team";
    }else {
    try {
    dataBase.insertVote(user.username, String.valueOf(votingRequest.matchID), votingRequest.selectedTeam, votingRequest.team1 + " vs " + votingRequest.team2,votingRequest.gameType,votingRequest.groupStage);
    votingResponse.errorMsg = "your vote submitted";
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
}


    return votingResponse;
  }

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
            ">", "&gt;");
  }
}

