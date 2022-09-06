package com.techwave.airportmanagementsystem.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    private int regno;
    @Column(length = 30)
    private String manufacturername;
    @Column(length = 30)
    private int modelno;
    @Column(length = 30)
    private String planename;
    @Column(length = 5)
    private int capacity;
    @Column(length = 30)
    private String email;
    @Column(length = 10)
    private int houseno;
    @Column(length = 20)
    private String address;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String state;
    @Column(length = 20)
    private String country;
    @Column(length = 20)
    private int pinno;
}
