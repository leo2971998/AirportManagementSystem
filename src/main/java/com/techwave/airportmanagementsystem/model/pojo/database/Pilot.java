package com.techwave.airportmanagementsystem.model.pojo.database;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @OneToOne
    @JoinColumn(name = "PlaneId")

    private Airplane PlaneId;
    @Transient
    private Long airplaneId;
}
