package com.apollocurrrency.aplwallet.inttest.model.sc;

import lombok.Getter;

public enum SCType {
    APL20_PERSONAL_LOCKABLE("MyAPL20PersonalLockable", "APL20PersonalLockable"),
    APL20_LOCK("MyAPL20LOCK", "APL20LOCK"),
    APL20_FREEZE("MyAPL20FREEZE", "APL20FREEZE"),
    APL20_BUY("MyAPL20BUY", "APL20BUY"),
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
