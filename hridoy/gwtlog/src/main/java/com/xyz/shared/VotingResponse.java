package com.xyz.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class VotingResponse implements IsSerializable {
    public boolean successful;
    public String errorMsg;

    public String username;
}
