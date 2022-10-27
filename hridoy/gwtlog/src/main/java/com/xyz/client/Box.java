package com.xyz.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class Box extends FlowPanel {

    public Box(){
//        super("div");
//        super.setStyleName("box");
    }

    public void setText(String text){
        super.getElement().setInnerText(text);
    }

        public void addClickHandler(ClickHandler handler){
            super.addBitlessDomHandler(handler, ClickEvent.getType());

        }
    }
