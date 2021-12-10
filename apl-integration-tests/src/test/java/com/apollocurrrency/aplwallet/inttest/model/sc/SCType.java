package com.apollocurrrency.aplwallet.inttest.model.sc;

import lombok.Getter;

public enum SCType {
    APL20_PERSONAL_LOCKABLE("MyAPL20PersonalLockable", "APL20PersonalLockable"),
    APL20_LOCK("MyAPL20LOCK", "APL20LOCK"),
    ESCROW("MyTokenEscrow", "TokenEscrow");

    @Getter
    private final String contractName;
    @Getter
    private final String baseContract;

    SCType(String contractName, String baseContract) {
        this.contractName = contractName;
        this.baseContract = baseContract;
    }
}
