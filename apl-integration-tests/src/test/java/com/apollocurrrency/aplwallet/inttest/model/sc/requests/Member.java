package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String function;
    private List<String> input = new ArrayList<>();


    public Member(String function) {
        this.function = function;
    }

    public Member() {
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }
}
