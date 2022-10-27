package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class TopBar implements IsWidget {
    private final   Box bar = new Box();
    private ClickHandler loginHandler;
    private ClickHandler signupHandler;
    public TopBar() {
        bar.setStyleName("bar");
        //----------------------------------------------------------------------------------->
        Box subBar2 = new Box();
        subBar2.addStyleName("flex-center");
        subBar2.getElement().setAttribute("style", "height:10vh; width:100vw;");
        Button home = new Button("Home");
        Button teams = new Button("Teams");
        Button service = new Button("Service");
        Button deals = new Button("Deals");
        Button tasks = new Button("Tasks");
        Button support = new Button("Support");
        Box buttBar = new Box();
        buttBar.getElement().setAttribute("style", "height:5vh; width:50vw ; margin-top:30px;margin-left:200px");
        buttBar.add(home);
        buttBar.add(teams);
        buttBar.add(service);
        buttBar.add(deals);
        buttBar.add(tasks);
        buttBar.add(support);
        subBar2.add(buttBar);
        home.setStyleName("button-bar");
        teams.setStyleName("button-bar");
        service.setStyleName("button-bar");
        deals.setStyleName("button-bar");
        tasks.setStyleName("button-bar");
        support.setStyleName("button-bar");
        //----------------------------------------------------------------------------------->
        Box buttBar2 = new Box();
        buttBar2.getElement().setAttribute("style", "height:5vh; width:10vw ; margin-top:22px;margin-left:70px;");
        buttBar2.addStyleName("flex-center");
        Button logIn = new Button("LogIn");
        Button signUp = new Button("SignUp");
        Label or = new Label("or");
        or.getElement().setAttribute("style","border-bottom: 1px solid #6698FF;margin-left:5px;color:white");
        buttBar2.add(logIn);
        buttBar2.add(or);
        buttBar2.add(signUp);
        subBar2.add(buttBar2);

        logIn.setStyleName("log-sign");
        signUp.setStyleName("log-sign");

        bar.add(subBar2);

        //----------------------------------------------------------------------------------->
        logIn.addClickHandler(this::goToLogin);
        signUp.addClickHandler(this::goToSignup);
    }
    private void goToLogin(ClickEvent clickEvent) {
        if (loginHandler != null){
            loginHandler.onClick(clickEvent);
        }
    }
    public void addSwitchToLoginHandler(ClickHandler handler){
        this.loginHandler = handler;
    }
    //----------------------------------------------------------------------------------->
    private void goToSignup(ClickEvent clickEvent) {

        if(signupHandler != null){
            signupHandler.onClick(clickEvent);
        }
    }
    public void addSwitchToSignupHandler(ClickHandler handler){
        this.signupHandler = handler;
    }

    @Override
    public Widget asWidget() {
        return bar;
    }
}
