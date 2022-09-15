package com.techwave.airportmanagementsystem.model.pojo.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import javax.persistence.UniqueConstraint;
@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlaneId;
    @Pattern(regexp = "^\\d{10}$", message = "Only allows 10 digit numbers")
    @Column(length = 10, unique = true)
    private String regNo;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    @Column(length = 30)
    private String ManufacturerName;
    @NotNull(message = "Required")
    @Column(length = 30)
    private Integer ModelNo;
    @NotBlank(message = "Required")
    @Column(length = 30)
    private String PlaneName;
    @NotNull(message = "Required")
    @Column(length = 5)
    private Integer Capacity;
    @NotBlank(message = "Required")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;
    @NotNull(message = "Required")
    @Column(length = 7)
    private Integer HouseNo;
    @NotBlank(message = "Required")
    @Column(length = 20)
    private String Address;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    @Column(length = 20)
    private String City;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    @Column(length = 20)
    private String State;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    @Column(length = 20)
    private String Country;
    @Pattern(regexp = "^\\d{7}$", message = "Only allows 7 digits number")
    @Column(length = 7)
    private String PinCode;
    public Airplane(){}

    public Airplane(Long planeId, String regNo, String manufacturerName, Integer modelNo, String planeName, Integer capacity, String email, Integer houseNo, String address, String city, String state, String country, String pinCode) {
        PlaneId = planeId;
        this.regNo = regNo;
        ManufacturerName = manufacturerName;
        ModelNo = modelNo;
        PlaneName = planeName;
        Capacity = capacity;
        this.email = email;
        HouseNo = houseNo;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PinCode = pinCode;
    }

    public Long getPlaneId() {
        return PlaneId;
    }

    public void setPlaneId(Long planeId) {
        PlaneId = planeId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        ManufacturerName = manufacturerName;
    }

    public Integer getModelNo() {
        return ModelNo;
    }

    public void setModelNo(Integer modelNo) {
        ModelNo = modelNo;
    }

    public String getPlaneName() {
        return PlaneName;
    }

    public void setPlaneName(String planeName) {
        PlaneName = planeName;
    }

    public Integer getCapacity() {
        return Capacity;
    }

    public void setCapacity(Integer capacity) {
        Capacity = capacity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(Integer houseNo) {
        HouseNo = houseNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String pinCode) {
        PinCode = pinCode;
    }
}
