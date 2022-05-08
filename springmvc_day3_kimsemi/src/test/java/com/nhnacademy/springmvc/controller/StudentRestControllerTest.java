package com.nhnacademy.springmvc.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.StudentRepositoryImpl;
import javax.servlet.http.Cookie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
    void modifyStudent() throws Exception {
        when(studentRepository.exists(anyLong())).thenReturn(true);
        when(studentRepository.getStudent(anyLong()))
            .thenReturn(Student.create(anyLong(),anyString()));

        MvcResult mvcResult = mockMvc.perform(put("/students/" + anyLong()))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(get("/students/2"))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    void successCreateStudent() throws Exception {
        mockMvc.perform(get("/students"))
            .andExpect(status().isOk());
    }

    @Test
    void createStudent() throws Exception {
        mockMvc.perform(post("/students")
                .cookie(new Cookie("SESSION", "12345")))
            .andExpect(status().isCreated());
    }
}