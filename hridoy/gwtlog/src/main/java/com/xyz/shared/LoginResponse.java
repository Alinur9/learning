package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginResponse implements IsSerializable {
    public boolean successful;
    public String errorMsg;

    public String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        LoginResponse.username = username;
    }

    private static  String username ;
}
