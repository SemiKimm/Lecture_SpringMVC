package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Data
public class StudentRegisterRequest {
    @NotBlank
    String name;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$")
    String email;
    @Max(100)
    @Min(0)
    int score;
    @Length(min = 0, max = 200)
    String comment;
}
