package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRegisterRequest;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StudentRestController {
    private final StudentRepository studentRepository;

    public StudentRestController(
        StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PutMapping("/students/{studentId}")
    public void modifyStudent(@PathVariable("studentId") long studentId,
                              HttpServletResponse response,
                              @RequestBody StudentRegisterRequest request) throws IOException {
        Student student = studentRepository.getStudent(studentId);
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setScore(request.getScore());
        student.setComment(request.getComment());

        studentRepository.modify(student);
        response.sendRedirect("/student/" + studentId);
    }

    @GetMapping("/students/{studentId}")
    public void getStudent(@PathVariable("studentId") long studentId,
                           HttpServletResponse response)
        throws IOException {
        response.sendRedirect("/student/" + studentId);
    }

    @GetMapping("/students")
    public String successCreateStudent() {
        return "createStudent success";
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRegisterRequest request) {
        studentRepository.register(request.getName(), request.getEmail(), request.getScore(),
            request.getComment());
    }
}
