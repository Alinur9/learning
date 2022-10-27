package com.xyz.client;

import com.google.gwt.user.client.ui.*;

public class PasswordField implements IsWidget {
    private final FlowPanel outLayer = new FlowPanel();
    private final Label label = new Label();
    private final PasswordTextBox passwordTextBox = new PasswordTextBox();

    public PasswordField(String label,String text){

        outLayer.addStyleName("text-field");
        outLayer.add(this.label);
        outLayer.add(passwordTextBox);

        this.label.addStyleName("label");
        this.passwordTextBox.addStyleName("text-box");
        setLabel(label);
        setText(text);
    }

    public void setLabel(String label){
        this.label.setText(label == null ? "" : label);
    }
    public void setText(String text){
        this.passwordTextBox.setText(text == null ? "" : text);
    }
    public String getText(){
        return this.passwordTextBox .getText();
    }
    @Override
    public Widget asWidget() {
        return outLayer;
    }
}
