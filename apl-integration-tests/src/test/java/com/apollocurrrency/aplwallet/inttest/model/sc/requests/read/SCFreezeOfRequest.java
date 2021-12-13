package com.apollocurrrency.aplwallet.inttest.model.sc.requests.read;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.Member;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;
import java.util.List;

public class SCFreezeOfRequest extends SCRequestBase {
    private List<Member> members = new ArrayList<>();

    public SCFreezeOfRequest(String address, String account) {
        this.address = address;
        Member member = new Member("freezeOf");
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
