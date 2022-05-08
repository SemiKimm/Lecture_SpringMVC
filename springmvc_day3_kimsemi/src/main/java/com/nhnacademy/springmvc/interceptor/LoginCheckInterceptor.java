package com.nhnacademy.springmvc.interceptor;

import java.util.Arrays;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        Cookie sessionCookie;
        sessionCookie =
            Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("SESSION"))
                .findFirst().orElse(null);
        if (Objects.isNull(sessionCookie)
            || Objects.isNull(sessionCookie.getValue())) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
