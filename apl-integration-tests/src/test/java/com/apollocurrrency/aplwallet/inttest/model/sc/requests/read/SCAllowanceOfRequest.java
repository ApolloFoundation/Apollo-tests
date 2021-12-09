package com.apollocurrrency.aplwallet.inttest.model.sc.requests.read;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.Member;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;
import java.util.List;

public class SCAllowanceOfRequest extends SCRequestBase {
    private List<Member> members = new ArrayList<>();

    public SCAllowanceOfRequest(String address,String owner,String spender) {
        this.address = address;
        Member member = new Member("allowance");
        member.getInput().add(owner);
        member.getInput().add(spender);
        this.members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
