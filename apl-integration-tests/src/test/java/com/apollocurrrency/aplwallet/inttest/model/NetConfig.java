package com.apollocurrrency.aplwallet.inttest.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class NetConfig {
    private List<String> peers;
    private String chainId;
}
