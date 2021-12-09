package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class SCRequestBase implements ISCWrite {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String address;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String sender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<String> params;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String fuelPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String fuelLimit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String source;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String secretPhrase;




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
