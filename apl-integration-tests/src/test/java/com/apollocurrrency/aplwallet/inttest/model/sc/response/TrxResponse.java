package com.apollocurrrency.aplwallet.inttest.model.sc.response;

import java.util.List;

public class TrxResponse {
    private String protocol;
    private String newErrorCode;
    private String errorDetails;
    private String errorDescription;
    private int requestProcessingTime;
    private String tx;
    private List<Result> results;

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

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getNewErrorCode() {
        return newErrorCode;
    }

    public void setNewErrorCode(String newErrorCode) {
        this.newErrorCode = newErrorCode;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
