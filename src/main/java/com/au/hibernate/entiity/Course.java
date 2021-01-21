package com.au.hibernate.entiity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course_A")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private  String courseName;

    @ManyToMany(mappedBy = "course")
    private List<Employee> employeeList = new ArrayList<>();
}
