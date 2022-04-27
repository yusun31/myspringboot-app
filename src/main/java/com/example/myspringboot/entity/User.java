package com.example.myspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "이름은 필수 입력항목입니다.")
    @Column
    private String name;

    @NotBlank(message = "이메일은 필수 입력항목입니다.")
    @Column(unique=true)
    private String email;
}
