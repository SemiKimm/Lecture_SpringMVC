package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public boolean existUser(String id) {
        return users.containsKey(id);
    }

    @Override
    public boolean match(String id, String pwd) {
        return this.users.get(id).getPwd().equals(pwd);
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public void addUser(User user) {
        this.users.put(user.getId(), user);
    }
}
