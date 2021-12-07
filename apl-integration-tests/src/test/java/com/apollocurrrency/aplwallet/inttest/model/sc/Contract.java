package com.apollocurrrency.aplwallet.inttest.model.sc;

public class Contract {
    private String address;
    private String owner;
    private String transaction;
    private String signature;
    private String fullHash;
    private long timestamp;
    private String amount;
    private String status;
    private String name;
    private String baseContract;
    private String params;
    private String src;
    private String fuelLimit;
    private String fuelPrice;
    private String fuelCharged;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getFullHash() {
        return fullHash;
    }

    public void setFullHash(String fullHash) {
        this.fullHash = fullHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseContract() {
        return baseContract;
    }

    public void setBaseContract(String baseContract) {
        this.baseContract = baseContract;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getFuelLimit() {
        return fuelLimit;
    }

    public void setFuelLimit(String fuelLimit) {
        this.fuelLimit = fuelLimit;
    }

    public String getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(String fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public String getFuelCharged() {
        return fuelCharged;
    }

    public void setFuelCharged(String fuelCharged) {
        this.fuelCharged = fuelCharged;
    }
}
