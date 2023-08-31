package com.example.demo.dto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
public class MemberDTO {
    private Long id;
    @Email
    private String name;
    @Max(5)
    private Integer age;
}
