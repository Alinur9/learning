package com.xyz.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.xyz.shared.LoginRequest;
import com.xyz.shared.LoginResponse;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
  void greetServer(String input, AsyncCallback<String> callback)
      throws IllegalArgumentException;

  void login(LoginRequest request, AsyncCallback<LoginResponse> callback) throws RuntimeException;

}
