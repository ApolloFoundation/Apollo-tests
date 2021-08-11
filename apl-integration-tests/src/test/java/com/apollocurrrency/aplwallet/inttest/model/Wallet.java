package com.apollocurrrency.aplwallet.inttest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wallet {
    private String user;
    private String pass;
    private String publicKey;
    private boolean vault;
    private String ethAddress;
    private String accountId;

    public Wallet(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Wallet(String user,String accountId, String pass) {
        this.user = user;
        this.accountId = accountId;
        this.pass = pass;
    }

    public Wallet(String user, String pass, boolean vault) {
        this.user = user;
        this.pass = pass;
        this.vault = vault;
    }

    public Wallet(String user, String pass, boolean vault, String accountId) {
        this.user = user;
        this.pass = pass;
        this.vault = vault;
        this.accountId = accountId;
    }


    public Wallet(String user, String pass, boolean vault, String ethAddress, String accountId) {
        this.user = user;
        this.pass = pass;
        this.vault = vault;
        this.ethAddress = ethAddress;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        String walletType =  (vault)? "Vault Wallet: ":"Standard Wallet: ";
        return walletType + getUser();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public boolean isVault() {
        return vault;
    }

    public void setVault(boolean vault) {
        this.vault = vault;
    }

    public String getEthAddress() {
        return ethAddress;
    }

    public void setEthAddress(String ethAddress) {
        this.ethAddress = ethAddress;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
