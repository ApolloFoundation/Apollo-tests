package com.apollocurrrency.aplwallet.inttest.model.sc.requests.write;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;

public class SCUnfreezeRequest extends SCRequestBase {

    public SCUnfreezeRequest(String address, String sender, String secretPhrase, String amount) {
        this.address = address;
        this.name = name = "unfreeze";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.value = "0";
        this.secretPhrase = secretPhrase;
        this.params = new ArrayList<>();
        this.params.add(amount);
    }
}
