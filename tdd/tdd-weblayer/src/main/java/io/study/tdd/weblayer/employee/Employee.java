package io.study.tdd.weblayer.employee;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;

    public Employee(Long id, String name){
        this.id = id;
        this.name = name;
    }
}