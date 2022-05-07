package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.LoginRequest;
import com.nhnacademy.springmvc.repository.UserRepository;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String doLogin(@ModelAttribute LoginRequest loginRequest,
                        HttpServletRequest request,
                        HttpServletResponse response){
        if(Objects.isNull(loginRequest.getId())||Objects.isNull(loginRequest.getPassword())){
            return "login";
        }
        if(!userRepository.match(loginRequest.getId(), loginRequest.getPassword())){
            return "login";
        }
        HttpSession session = request.getSession(true);
        Cookie cookie = new Cookie("SESSION", session.getId());

        response.addCookie(cookie);
        return "studentRegister";
    }

    @GetMapping
    public String login(@CookieValue(value="SESSION", required = false) String sessionCookie){
        if(Objects.nonNull(sessionCookie)&&!sessionCookie.isEmpty()){
            return "studentRegister";
        }

        return "login";
    }

}
