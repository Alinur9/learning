package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.xyz.shared.LoginRequest;
import com.xyz.shared.LoginResponse;

public class SignupUi implements IsWidget {

    private final GreetingServiceAsync service;
    Box box2 = new Box();
    TextField username = new TextField("Username", "");
    TextField email = new TextField("email", "");
    TextField password = new TextField("password", "");
    TextField confirmPassword = new TextField("confirm password", "");

    private ClickHandler topBarHandler;
    private ClickHandler signUpHandler;

    public SignupUi(GreetingServiceAsync greetingServiceAsync) {
        this.service = greetingServiceAsync;

        box2.setStyleName("sign-up");
        box2.getElement().setAttribute("style", " padding: 30px; border: 1px solid #ddd; box-shadow: .5px 1px 5px #00FFFF");

        box2.add(username);
        box2.add(email);
        box2.add(password);
        box2.add(confirmPassword);


        Box box3 = new Box();
        box2.add(box3);

        box3.getElement().setAttribute("style", "border: 0px; padding:10px; margin-top: 70px; margin-left : 30px");

        Button submitBtn = new Button("Submit");
        submitBtn.setStyleName("cancel-sub-btn");
        Button cancel = new Button("Cancel");
        cancel.setStyleName("cancel-sub-btn");
        box3.add(cancel);
        box3.add(submitBtn);

        cancel.addClickHandler(this::goToTopBar);
        submitBtn.addClickHandler(this::goToPage);
    }

    private void goToPage(ClickEvent clickEvent) {
        LoginRequest request = new LoginRequest();
        if (username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || confirmPassword.getText().isEmpty()){
            Window.alert("before sign up please confirm your information ");
            return;
        }else if (!password.getText().equals(confirmPassword.getText())){
            Window.alert("given password didn't matching");
            return;
        }
        request.username = username.getText();
        request.email = email.getText();
        request.password = password.getText();

        service.signup(request, new AsyncCallback<LoginResponse>() {


            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("server error when try to sign up ");
            }

            @Override
            public void onSuccess(LoginResponse loginResponse) {

                if (loginResponse.successful) {
                    if (signUpHandler != null){
                        signUpHandler.onClick(clickEvent);
                    }
                }else {
                    Window.alert(loginResponse.errorMsg);
                }

            }
        });
    }
    public void addSwitchToSignUpHandler(ClickHandler handler){
        this.signUpHandler = handler;
    }



        private void goToTopBar(ClickEvent clickEvent) {
            if (topBarHandler!= null){
                topBarHandler.onClick(clickEvent);
            }
        }
        public void addSwitchToCancelHandler(ClickHandler handler){
            this.topBarHandler = handler;
        }
    @Override
    public Widget asWidget() {
        return box2;
    }
}
