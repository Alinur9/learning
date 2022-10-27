package com.xyz.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.xyz.shared.LoginRequest;
import com.xyz.shared.LoginResponse;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;

  LoginResponse login(LoginRequest request) throws RuntimeException;

}
