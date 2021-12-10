package com.apollocurrrency.aplwallet.inttest.model.sc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConvertId {
    public String protocol;
    public int requestProcessingTime;
    @JsonProperty("long")
    public String longId;
    private String rs;
    private String ulong;
    private String hex;


    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getUlong() {
        return ulong;
    }

    public void setUlong(String ulong) {
        this.ulong = ulong;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getRequestProcessingTime() {
        return requestProcessingTime;
    }

    public void setRequestProcessingTime(int requestProcessingTime) {
        this.requestProcessingTime = requestProcessingTime;
    }

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }
}
