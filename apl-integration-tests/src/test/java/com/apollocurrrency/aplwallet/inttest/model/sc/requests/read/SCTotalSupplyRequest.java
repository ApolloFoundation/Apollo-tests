package com.apollocurrrency.aplwallet.inttest.model.sc.requests.read;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.Member;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class SCTotalSupplyRequest extends SCRequestBase {
    private List<Member> members = new ArrayList<>();

    public SCTotalSupplyRequest(String address) {
        this.address = address;
        Member member = new Member("totalSupply");
        this.members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
