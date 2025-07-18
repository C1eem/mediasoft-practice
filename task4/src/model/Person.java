package model;

import annotations.JsonField;

public class Person {
    @JsonField(name = "firstName")
    private String name;

    @JsonField(name = "years")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}