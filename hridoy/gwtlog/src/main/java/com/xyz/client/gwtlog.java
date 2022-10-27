package com.xyz.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
public class gwtlog implements EntryPoint {
  public static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  public void onModuleLoad() {
    RootPanel root = RootPanel.get();

    LoginUi loginUi = new LoginUi(greetingService);
    SignupUi signupUi = new SignupUi();
    TopBar topBar = new TopBar();

    topBar.addSwitchToSignupHandler(e->{
      root.remove(loginUi);
      root.add(signupUi);
    });

    topBar.addSwitchToLoginHandler(e->{
      root.remove(signupUi);
      root.add(loginUi);
    });

    loginUi.addSwitchToCancelHandler(e->{
      root.remove(loginUi);
    });

    signupUi.addSwitchToCancelHandler(e->{
      root.remove(signupUi);
    });


    root.add(topBar);

   // root.add(loginUi);
  }
}
