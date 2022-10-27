package com.xyz.client;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.xyz.shared.LoginRequest;
import com.xyz.shared.LoginResponse;

public class LoginUi implements IsWidget {
    private final Box box1 = new Box();
    private final GreetingServiceAsync service;
    Button submit = new Button("Submit");
    TextField username = new TextField("Username","");
    PasswordField password = new PasswordField("Password","");
    private ClickHandler topBarHandler;
    private ClickHandler testHandler;
    public LoginUi(GreetingServiceAsync greetingService) {
        this.service = greetingService;
        Box box2 = new Box();
        box1.add(box2);
        box2.setStyleName("log-in");
        box2.getElement().setAttribute("style", " padding: 30px; border: 1px solid #ddd; box-shadow: .5px 1px 5px #00FFFF");

        box2.add(username);

        box2.add(password);


        Box box3 = new Box();
        box2.add(box3);
        box3.getElement().setAttribute("style", "border: 0px; padding:10px; margin-top: 60px; margin-left : 30px");

        Button cancel = new Button("Cancel");
        cancel.setStyleName("cancel-sub-btn");

        submit.setStyleName("cancel-sub-btn");
        Button forgetPass = new Button("Forget password");
        forgetPass.setStyleName("forget-pass");
        box3.add(cancel);
        box3.add(submit);
        box3.add(forgetPass);


        cancel.addClickHandler(this::goToTopBar);
        this.submit.addClickHandler(this::goToPage);
    }


    private void goToPage(ClickEvent clickEvent) {
        LoginRequest request = new LoginRequest();
        request.password= password.getText();
        request.username = username.getText();
        service.login(request, new AsyncCallback<LoginResponse>() {
            @Override
            public void onFailure(Throwable throwable) {
                username.setText(" Login error!!!");
            }

            @Override
            public void onSuccess(LoginResponse loginResponse) {
                username.setText("Login success: " + loginResponse.successful);
            }
        });

        if (!username.getText().isEmpty() && !username.getText().contains(" ") && !password.getText().isEmpty() && !password.getText().contains(" ")){
            this.testHandler.onClick(clickEvent);
        }
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
        return box1;
    }
}
