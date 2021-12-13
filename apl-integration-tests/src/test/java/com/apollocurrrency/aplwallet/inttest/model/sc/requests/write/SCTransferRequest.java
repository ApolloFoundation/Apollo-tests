package com.apollocurrrency.aplwallet.inttest.model.sc.requests.write;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;

public class SCTransferRequest extends SCRequestBase {

    public SCTransferRequest(String address, String sender, String secretPhrase,String recipient,String amount) {
        this.address = address;
        this.name = name = "transfer";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.value = "0";
        this.secretPhrase = secretPhrase;
        this.params = new ArrayList<>();
        this.params.add(recipient);
        this.params.add(amount);
    }
}
