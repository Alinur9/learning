package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SignupUi implements IsWidget {

    private final Box box1 = new Box();

    private ClickHandler topBarHandler;

    public SignupUi() {

        Box box2 = new Box();
        box1.add(box2);
        box2.setStyleName("sign-up");
        box2.getElement().setAttribute("style", " padding: 30px; border: 1px solid #ddd; box-shadow: .5px 1px 5px #00FFFF");

        box2.add(new TextField("Username", ""));
        box2.add(new TextField("Email", ""));
        box2.add(new TextField("Phone", ""));
        box2.add(new PasswordField("Password", ""));
        box2.add(new PasswordField("Re-Type", ""));

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
