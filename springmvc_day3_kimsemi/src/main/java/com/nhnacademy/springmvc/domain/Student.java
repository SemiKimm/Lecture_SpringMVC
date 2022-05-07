package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Integer score;
    @Getter
    @Setter
    private String comment;

    public static Student create(Long id, String name){return new Student(id, name);}

    private Student(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public static Student hideScore(Student student){
        Student hideScoreStudent = Student.create(student.getId(), student.getName());
        hideScoreStudent.setEmail(student.getEmail());
        hideScoreStudent.setScore(null);
        hideScoreStudent.setComment(student.getComment());
        return hideScoreStudent;
    }
}
