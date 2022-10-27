package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginResponse implements IsSerializable {
    public boolean successful;
    public String errorMsg;
}
