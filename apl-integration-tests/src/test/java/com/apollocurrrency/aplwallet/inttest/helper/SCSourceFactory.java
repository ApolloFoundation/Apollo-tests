package com.apollocurrrency.aplwallet.inttest.helper;

import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SCSourceFactory {
    private static final String CONTRACT_TEMPLATE = "class %s extends %s {\n constructor(){\n super(%s);\n }\n }";

    public static String createSCSCSource(SCType type, String ... params) {
        String constructorParams  = Arrays.stream(params).map(s -> (s.startsWith(","))?s:'\''+s+'\'' ).collect(Collectors.joining(","));
        return String.format(CONTRACT_TEMPLATE, type.getContractName(), type.getBaseContract(), constructorParams);
    }

}

