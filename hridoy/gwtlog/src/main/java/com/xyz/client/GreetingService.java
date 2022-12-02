package com.xyz.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.xyz.shared.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;

  LoginResponse login(LoginRequest request) throws RuntimeException;

  LoginResponse signup(LoginRequest request) throws RuntimeException;

  ArrayList<MatchForVoting> getMatchesForVoting() throws RuntimeException;
  ArrayList<MatchForVoting> getUsersWinnerTeam() throws RuntimeException;



  VotingResponse votedTeam(VotingRequest votingRequest) throws RuntimeException;
}
