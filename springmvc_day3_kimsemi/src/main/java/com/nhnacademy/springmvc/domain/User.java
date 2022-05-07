package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    private final String id;
    @Getter
    @Setter
    private String pwd;

    public User(String id) {
        this.id = id;
    }
}
