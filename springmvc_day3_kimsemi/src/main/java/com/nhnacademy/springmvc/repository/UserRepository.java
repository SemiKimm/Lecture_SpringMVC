package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;

public interface UserRepository {
    boolean existUser(String id);

    boolean match(String id, String pwd);

    User getUser(String id);

    void addUser(User user);
}
