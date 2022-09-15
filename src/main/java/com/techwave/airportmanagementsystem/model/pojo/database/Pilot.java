package com.techwave.airportmanagementsystem.model.pojo.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Entity
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PilotId;
    @Column(length = 12, unique = true)
    @Pattern(regexp = "^\\d{12}$", message = "Only allows 12 digit numbers")
    private String ssNo;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    private String PilotName;
    @Column(length = 10, unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "Only allows 10 digit numbers")
    private String licenseNo;
    @NotBlank(message = "Required")
    private String Dob;
    @Column(length = 30)
    @NotBlank(message = "Required")
    private String Gender;
    @Column(unique = true)
    @NotBlank(message = "Required")
    private String mobileNo;
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
    @OneToOne(mappedBy="AirPlane")
    @JoinColumn(name = "PlaneId")

    private Airplane PlaneId;

    public Pilot() {
    }

    public Pilot(Long pilotId, String ssNo, String pilotName, String licenseNo, String dob, String gender, String mobileNo, String email, Integer houseNo, String address, String city, String state, String country, String pinCode, Airplane planeId) {
        PilotId = pilotId;
        this.ssNo = ssNo;
        PilotName = pilotName;
        this.licenseNo = licenseNo;
        Dob = dob;
        Gender = gender;
        this.mobileNo = mobileNo;
        this.email = email;
        HouseNo = houseNo;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PinCode = pinCode;
        PlaneId = planeId;
    }

    public Long getPilotId() {
        return PilotId;
    }

    public void setPilotId(Long pilotId) {
        PilotId = pilotId;
    }

    public String getSsNo() {
        return ssNo;
    }

    public void setSsNo(String ssNo) {
        this.ssNo = ssNo;
    }

    public String getPilotName() {
        return PilotName;
    }

    public void setPilotName(String pilotName) {
        PilotName = pilotName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public Airplane getPlaneId() {
        return PlaneId;
    }

    public void setPlaneId(Airplane planeId) {
        PlaneId = planeId;
    }
}
