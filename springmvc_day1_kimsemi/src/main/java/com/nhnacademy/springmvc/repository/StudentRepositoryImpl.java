package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private long id = 0L;

    @Override
    public boolean exists(long id) {
        return this.studentMap.containsKey(id);
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        id++;
        Student student = Student.create(id, name);
        student.setEmail(email);
        student.setScore(score);
        student.setComment(comment);

        this.studentMap.put(id, student);

        return student;
    }

    @Override
    public Student getStudent(long id) {
        return exists(id) ? studentMap.get(id) : null;
    }
}