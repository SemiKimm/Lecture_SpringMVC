package com.nhnacademy.springmvc.domain;

import lombok.Value;

@Value
public class LoginRequest {
    String id;
    String password;
}
