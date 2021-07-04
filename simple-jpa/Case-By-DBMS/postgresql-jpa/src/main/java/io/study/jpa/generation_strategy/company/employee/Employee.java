package io.study.jpa.generation_strategy.company.employee;

import io.study.jpa.generation_strategy.company.department.Department;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMP", schema = "public")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

}
