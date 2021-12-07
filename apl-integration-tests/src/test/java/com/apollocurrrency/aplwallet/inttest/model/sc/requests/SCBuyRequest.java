package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import java.util.ArrayList;
import java.util.List;

public class SCBuyRequest extends SCRequestBase {

    public SCBuyRequest(String address, String sender, String value, String secretPhrase) {
        this.address = address;
        this.name = name = "buy";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.value = value;
        this.secretPhrase = secretPhrase;
    }


}
