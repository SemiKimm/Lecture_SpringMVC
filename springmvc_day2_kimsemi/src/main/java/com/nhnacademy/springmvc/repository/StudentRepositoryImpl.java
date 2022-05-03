package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public void modify(Student student) {
        Student dbStudent = getStudent(student.getId());
        if (Objects.isNull(dbStudent)) {
            throw new StudentNotFoundException();
        }
        dbStudent.setName(student.getName());
        dbStudent.setEmail(student.getEmail());
        dbStudent.setScore(student.getScore());
        dbStudent.setComment(student.getComment());
    }
}