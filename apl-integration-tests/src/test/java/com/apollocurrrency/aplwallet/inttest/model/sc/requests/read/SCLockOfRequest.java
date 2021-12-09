package com.apollocurrrency.aplwallet.inttest.model.sc.requests.read;

import com.apollocurrrency.aplwallet.inttest.model.sc.requests.Member;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SCRequestBase;

import java.util.ArrayList;
import java.util.List;

public class SCLockOfRequest extends SCRequestBase {
    private List<Member> members = new ArrayList<>();

    public SCLockOfRequest(String address,String account) {
        this.address = address;
        Member member = new Member("lockOf");
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
