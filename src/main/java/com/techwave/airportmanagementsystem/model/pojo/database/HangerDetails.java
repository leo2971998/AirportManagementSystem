package com.techwave.airportmanagementsystem.model.pojo.database;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class HangerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, nullable = false)
    private int Ssno;
    @Column(length = 30, nullable = false)
    private String ManagerName;
    @Column(length = 30, nullable = false)
    private String HangerLocation;
    @Column(length = 30, nullable = false)
    private int HangerCapacity;
    @Column(length = 30, nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate Dob;
    @Column(length = 10, nullable = false)
    private String Gender;
    @Column(length = 20, nullable = false)
    private String MobileNo;
    @Column(length = 30)
    private String Email;
    @Column(length = 7, nullable = false)
    private int HouseNo;
    @Column(length = 20, nullable = false)
    private String Address;
    @Column(length = 20, nullable = false)
    private String City;
    @Column(length = 20, nullable = false)
    private String State;
    @Column(length = 20, nullable = false)
    private String Country;
    @Column(length = 20, nullable = false)
    private int PinCode;

    public int getSsno() {
        return Ssno;
    }

    public void setSsno(int ssno) {
        Ssno = ssno;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public String getHangerLocation() {
        return HangerLocation;
    }

    public void setHangerLocation(String hangerLocation) {
        HangerLocation = hangerLocation;
    }

    public int getHangerCapacity() {
        return HangerCapacity;
    }

    public void setHangerCapacity(int hangerCapacity) {
        HangerCapacity = hangerCapacity;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(int houseNo) {
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

    public int getPinCode() {
        return PinCode;
    }

    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }

    public HangerDetails() {
    }

    public HangerDetails(int ssno, String managerName, String hangerLocation, int hangerCapacity, LocalDate dob, String gender, String mobileNo, String email, int houseNo, String address, String city, String state, String country, int pinCode) {
        Ssno = ssno;
        ManagerName = managerName;
        HangerLocation = hangerLocation;
        HangerCapacity = hangerCapacity;
        Dob = dob;
        Gender = gender;
        MobileNo = mobileNo;
        Email = email;
        HouseNo = houseNo;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PinCode = pinCode;
    }
}
