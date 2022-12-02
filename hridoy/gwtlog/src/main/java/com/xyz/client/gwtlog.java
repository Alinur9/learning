package com.xyz.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
public class gwtlog implements EntryPoint {
  public static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  public void onModuleLoad() {
    RootPanel root = RootPanel.get();

    LoginUi loginUi = new LoginUi(greetingService);
    MatchListUi matchList = new MatchListUi(greetingService);
    SignupUi signupUi = new SignupUi(greetingService);
    WinnerTeamUi winnerTeamUi = new WinnerTeamUi(greetingService);
    TopBar topBar = new TopBar();

    topBar.addSwitchToSignupHandler(e->{
      root.remove(loginUi);
      root.remove(matchList);
      root.add(signupUi);
    });

    topBar.addSwitchToLoginHandler(e->{
      root.remove(signupUi);
      root.remove(matchList);
      root.add(loginUi);
    });

    loginUi.addSwitchToCancelHandler(e->{
      root.remove(loginUi);
    });

    signupUi.addSwitchToCancelHandler(e->{
      root.remove(signupUi);
    });

    loginUi.addSwitchToLogInHandler(e->{
      root.remove(loginUi);
      root.add(matchList);
            });
    signupUi.addSwitchToSignUpHandler(e->{
      root.remove(signupUi);
      root.add(matchList);
    });
    matchList.addSwitchToLogoutHandler(e->{
      root.remove(matchList);
      root.remove(winnerTeamUi);
    });

    matchList.addSwitchToWinnerHandler(e->{
      root.remove(matchList);
      root.add(winnerTeamUi);
    });
    winnerTeamUi.addSwitchToLogoutHandler(e->{
      root.remove(winnerTeamUi);
    });

    winnerTeamUi.addSwitchToMatchListUi(e->{
      root.remove(winnerTeamUi);
      root.add(matchList);
    });


    root.add(topBar);
    

    // root.add(loginUi);
  }
}
