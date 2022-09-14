package com.techwave.airportmanagementsystem.model.pojo.database;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PilotId;
    @Column(length = 10)
    private Integer Ssno;
    @Column(length = 30)
    private String PilotName;
    @Column(length = 30)
    private Integer LicenseNo;
    @Column(length = 30)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate Dob;
    @Column(length = 30)
    private String Gender;
    @Column(length = 30)
    private String MobileNo;
    @Column(length = 30)
    private String Email;
    @Column(length = 7)
    private Integer HouseNo;
    @Column(length = 20)
    private String Address;
    @Column(length = 20)
    private String City;
    @Column(length = 20)
    private String State;
    @Column(length = 20)
    private String Country;
    @Column(length = 20)
    private Integer PinCode;
    @OneToOne
    @JoinColumn(name = "PlaneId")
    private Airplane PlaneId;
    public Pilot() {
    }

    public Pilot(long pilotId, Integer ssno, String pilotName, Integer licenseNo, LocalDate dob, String gender, String mobileNo, String email, Airplane planeId, Integer houseNo, String address, String city, String state, String country, Integer pinCode) {
        PilotId = pilotId;
        Ssno = ssno;
        PilotName = pilotName;
        LicenseNo = licenseNo;
        Dob = dob;
        Gender = gender;
        MobileNo = mobileNo;
        Email = email;
        PlaneId = planeId;
        HouseNo = houseNo;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PinCode = pinCode;
    }

    public long getPilotId() {
        return PilotId;
    }

    public void setPilotId(long pilotId) {
        PilotId = pilotId;
    }

    public Integer getSsno() {
        return Ssno;
    }

    public void setSsno(Integer ssno) {
        Ssno = ssno;
    }

    public String getPilotName() {
        return PilotName;
    }

    public void setPilotName(String pilotName) {
        PilotName = pilotName;
    }

    public Integer getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(Integer licenseNo) {
        LicenseNo = licenseNo;
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

    public Airplane getPlaneId() {
        return PlaneId;
    }

    public void setPlaneId(Airplane planeId) {
        PlaneId = planeId;
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

    public Integer getPinCode() {
        return PinCode;
    }

    public void setPinCode(Integer pinCode) {
        PinCode = pinCode;
    }
}
