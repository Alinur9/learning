package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginRequest implements IsSerializable {
    public String username;
    public String email;
    public String password;
}
