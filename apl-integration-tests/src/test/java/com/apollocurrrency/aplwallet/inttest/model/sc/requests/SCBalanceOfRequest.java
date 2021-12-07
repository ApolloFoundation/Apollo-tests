package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import java.util.ArrayList;
import java.util.List;

public class SCBalanceOfRequest extends SCRequestBase {
    private List<Member> members = new ArrayList<>();

    public SCBalanceOfRequest(String address,String account) {
        this.address = address;
        Member member = new Member("balanceOf");
        member.getInput().add(account);
        this.members.add(member);
    }


    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
