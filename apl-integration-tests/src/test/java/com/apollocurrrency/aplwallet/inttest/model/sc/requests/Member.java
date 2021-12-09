package com.apollocurrrency.aplwallet.inttest.model.sc.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String function;
    private List<String> input = new ArrayList<>();


    public Member(String function) {
        this.function = function;
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
