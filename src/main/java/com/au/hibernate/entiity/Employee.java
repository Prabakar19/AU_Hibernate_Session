package com.au.hibernate.entiity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="EmployeeTable_A")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name ="Emp_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name ="First_Name", length = 30)
    private String firstName;

    @Column(name ="Last_Name", length = 30)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Address> addressList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Emp_Course_A", joinColumns = @JoinColumn(name = "EmpId"), inverseJoinColumns = @JoinColumn(name="Session_Id"))
    private Collection<Course> course = new HashSet<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
