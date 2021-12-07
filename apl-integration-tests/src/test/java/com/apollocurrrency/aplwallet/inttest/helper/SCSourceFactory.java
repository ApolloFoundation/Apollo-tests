package com.apollocurrrency.aplwallet.inttest.helper;

import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;

import java.text.DecimalFormat;

public class SCSourceFactory {

    public String createSCSCSource(SCType type,String name,String symbol,String cap,String initSupply,String rate) {
        String source = null;
        String atomCap =  String.valueOf(Float.valueOf(Float.parseFloat(cap) * 100000000L).longValue());
        String atomInitSupply =  String.valueOf(Float.valueOf(Float.parseFloat(initSupply) * 100000000L).longValue());
        String atomRate = String.valueOf(Float.valueOf(Float.parseFloat(rate) * 100000000L).longValue());

        switch (type) {
            case APL20_PERSONAL_LOCKABLE:
                 source =  String.format("class MyAPL20PersonalLockable extends APL20PersonalLockable {\n      constructor(){\n       super('%s','%s','%s','%s','%s','0','0x67c5363f4019c423');\n      }\n    }",
                         name,symbol,atomCap,atomInitSupply,atomRate) ;
                break;

        }

        return source;
    }

}

