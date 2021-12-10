package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class SmartContract {
    private String name;
    private String sender;
    @Builder.Default
    private List<String> params = new ArrayList<>();
    private String value;
    private String fuelPrice;
    private String fuelLimit;
    private String source;
    private String secretPhrase;

}
