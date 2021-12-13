package com.apollocurrrency.aplwallet.inttest.model.sc.requests.write;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;

public class SCWithdrawEscrowRequest extends SCRequestBase {

    public SCWithdrawEscrowRequest(String address, String sender, String secretPhrase, String payee, String token) {
        this.address = address;
        this.name = name = "withdraw";
        this.fuelPrice ="10000";
        this.fuelLimit = "1000000000";
        this.sender = sender;
        this.value = "0";
        this.secretPhrase = secretPhrase;
        this.params = new ArrayList<>();
        this.params.add(payee);
        this.params.add(token);
    }
}
