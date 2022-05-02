package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter
    private long id;
    @Getter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private int score;
    @Getter
    @Setter
    private String comment;

    public static Student create(Long id, String name){return new Student(id, name);}

    private Student(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
