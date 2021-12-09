package com.apollocurrrency.aplwallet.inttest.model.sc.requests.write;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;

public class SCApproveRequest extends SCRequestBase {

    public SCApproveRequest(String address, String sender, String amount,String accountFor, String secretPhrase) {
        this.address = address;
        this.name = name = "approve";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.secretPhrase = secretPhrase;
        this.params = new ArrayList<>();
        this.params.add(accountFor);
        this.params.add(amount);
    }
}
