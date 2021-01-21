package com.au.hibernate.entiity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee_Details_A")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDetails implements Serializable {

    @Column(name = "Phone_No")
    private String phoneNo;

    @Column(name = "Email")
    private String email;

    @OneToOne
    @Id
    @MapsId
    private Employee employee;

    public EmployeeDetails(String phoneNo, String email, Employee employee) {
        this.phoneNo = phoneNo;
        this.email = email;
        this.employee = employee;
    }
}
