package com.xyz.client;

import com.google.gwt.user.client.ui.*;

public class TextField implements IsWidget {

    private final FlowPanel outLayer = new FlowPanel("div");
    private final Label label = new Label();
    private final TextBox textBox = new TextBox();

    public TextField(String label,String text){

        outLayer.addStyleName("text-field");
        outLayer.add(this.label);
        outLayer.add(textBox);

        this.label.addStyleName("label");
        this.textBox.addStyleName("text-box");
        setLabel(label);
        setText(text);
    }

    public void setLabel(String label){
        this.label.setText(label == null ? "" : label);
    }
    public void setText(String text){
        this.textBox.setText(text == null ? "" : text);
    }
    public String getText(){
        return this.textBox.getText();
    }
    @Override
    public Widget asWidget() {
        return outLayer;
    }
}
