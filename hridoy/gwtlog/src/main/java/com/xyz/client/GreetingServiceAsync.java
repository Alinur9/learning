package com.xyz.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.xyz.shared.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
  void greetServer(String input, AsyncCallback<String> callback)
      throws IllegalArgumentException;
  void login(LoginRequest request, AsyncCallback<LoginResponse> callback) throws RuntimeException;
  void signup(LoginRequest request, AsyncCallback<LoginResponse> callback) throws RuntimeException;

  void getMatchesForVoting(AsyncCallback<ArrayList<MatchForVoting>> callback) throws RuntimeException;
  void getUsersWinnerTeam(AsyncCallback<ArrayList<MatchForVoting>> callback) throws RuntimeException;

  void votedTeam(VotingRequest votingRequest, AsyncCallback<VotingResponse> callback) throws RuntimeException;

}
