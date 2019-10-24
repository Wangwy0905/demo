package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private Integer id;
    private String name;
    private String password;
    private Boolean sex;
    private Integer age;
    private Date birth;
}
