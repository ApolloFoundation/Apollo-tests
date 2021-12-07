package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

public class SCUnlockRequest extends SCRequestBase{

    public SCUnlockRequest(String address, String sender, String secretPhrase) {
        this.address = address;
        this.name = name = "unlock";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.value = value = "0";
        this.secretPhrase = secretPhrase;
    }
}
