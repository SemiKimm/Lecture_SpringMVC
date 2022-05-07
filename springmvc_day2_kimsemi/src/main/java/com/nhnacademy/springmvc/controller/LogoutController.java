package com.nhnacademy.springmvc.controller;

import java.util.Arrays;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie sessionCookie = Arrays.stream(cookies)
            .filter(cookie -> cookie.getName().equals("SESSION"))
            .findFirst().orElse(null);

        if (Objects.nonNull(sessionCookie)
            && Objects.nonNull(sessionCookie.getValue())) {
            Cookie deleteCookie = new Cookie("SESSION", null);
            deleteCookie.setMaxAge(0);
            response.addCookie(deleteCookie);
        }
        return "redirect:/login";
    }
}
