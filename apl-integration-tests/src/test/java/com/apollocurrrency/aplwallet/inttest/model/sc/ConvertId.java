package com.apollocurrrency.aplwallet.inttest.model.sc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConvertId {
    public String protocol;
    public int requestProcessingTime;
    @JsonProperty("long")
    public String longId;
    private String rs;
    private String ulong;
    private String hex;
}
