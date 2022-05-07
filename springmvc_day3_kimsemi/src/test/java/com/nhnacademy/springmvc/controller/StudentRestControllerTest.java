package com.nhnacademy.springmvc.controller;

import static org.mockito.Mockito.mock;

import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.StudentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class StudentRestControllerTest {
    private MockMvc mockMvc;

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepositoryImpl.class);
        StudentRestController studentRestController = new StudentRestController(studentRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(studentRestController)
            .build();
    }

    @Test
    void modifyStudent() {

    }

    @Test
    void getStudent() {
    }

    @Test
    void successCreateStudent() {
    }

    @Test
    void createStudent() {
    }
}