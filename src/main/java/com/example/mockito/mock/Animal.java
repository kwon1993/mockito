package com.example.mockito.mock;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Animal {

    private String name;
    private int age;
    private Boolean isFly;
    List<String> animalList;
}
