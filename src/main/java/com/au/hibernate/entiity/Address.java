package com.au.hibernate.entiity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Address_A")
@Setter
@Getter
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "Address_Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "City")
    private String city;

    @Column(name = "Pincode")
    private String pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Address(String streetName, String city, String pincode, Employee employee) {
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
        this.employee = employee;
    }
}
