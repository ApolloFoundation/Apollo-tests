package com.apollocurrrency.aplwallet.inttest.model.sc.requests.write;

import java.util.ArrayList;
import java.util.List;

public class CreateSmartContract {
    private String name;
    private String sender;
    private List<String> params;
    private String value;
    private String fuelPrice;
    private String fuelLimit;
    private String source;
    private String secretPhrase;


    public CreateSmartContract(String name, String sender, String value, String fuelPrice, String fuelLimit, String source, String secretPhrase) {
        this.name = name;
        this.sender = sender;
        this.value = value;
        this.fuelPrice = fuelPrice;
        this.fuelLimit = fuelLimit;
        this.source = source;
        this.secretPhrase = secretPhrase;
        this.params = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(String fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public String getFuelLimit() {
        return fuelLimit;
    }

    public void setFuelLimit(String fuelLimit) {
        this.fuelLimit = fuelLimit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSecretPhrase() {
        return secretPhrase;
    }

    public void setSecretPhrase(String secretPhrase) {
        this.secretPhrase = secretPhrase;
    }
}
