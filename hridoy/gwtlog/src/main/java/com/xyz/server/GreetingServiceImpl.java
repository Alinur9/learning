package com.xyz.server;

import com.xyz.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.xyz.shared.FieldVerifier;
import com.xyz.shared.LoginRequest;
import com.xyz.shared.LoginResponse;
import com.xyz.shared.User;

import java.util.HashMap;
import java.util.Map;

public class GreetingServiceImpl extends RemoteServiceServlet implements

    GreetingService {

    public static final Map<String, User> userDb = new HashMap<>();

  {
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    user1.username = "a1";
    user1.password = "p1";

    user2.username = "a2";
    user2.password = "p2";

    user3.username = "a3";
    user3.password = "p3";

    userDb.put(user1.username, user1);
    userDb.put(user2.username, user1);
    userDb.put(user3.username, user1);
  }


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
            + ".<br><br>It looks like you are using:<br>" + userAgent;
  }

  @Override
  public LoginResponse login(LoginRequest request) throws RuntimeException {
    System.out.println("Checking  database Or keeping in memory..... ???  ");

    User user = userDb.get(request.username);
    LoginResponse loginResponse = new LoginResponse();
    loginResponse.successful  = true;

    if(user == null) {
      loginResponse.successful = false;
      loginResponse.errorMsg = "No user found";
    } else if (!user.password.equals(request.password)) {
      loginResponse.successful= false;
      loginResponse.errorMsg = "Wrong password";
    }


    return loginResponse;
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

