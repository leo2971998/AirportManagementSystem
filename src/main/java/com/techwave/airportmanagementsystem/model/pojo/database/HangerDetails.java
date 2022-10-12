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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class HangerDetails {
    @Id
    @SequenceGenerator(
            name = "hanger_sequence",
            sequenceName = "hanger_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hanger_sequence"
    )
    private Long HangerId;
    @NotBlank(message = "Required")
    @Column(unique = true)
    private String ssNo;
    @NotBlank(message = "Required")
    private String ManagerName;
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$", message = "Only allows alphabets and space")
    @Column
    private String HangerLocation;
    @NotNull(message = "Required")
    private Integer HangerCapacity;
    @NotBlank(message = "Required")
    private String Dob;
    @NotBlank(message = "Required")
    private String Gender;
    @Column(unique = true)
    @NotBlank(message = "Required")
    @Pattern(regexp = "^\\d{10}$", message = "Only allows 10 digit numbers")
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
    private String Status;
    @Transient
    private String fromDate;
    @Transient
    private String toDate;
    @Transient
    private Long planeId;

}
