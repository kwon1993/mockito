package com.example.mockito.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Email
    private String email;
    private String password;

    @Builder
    private User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
