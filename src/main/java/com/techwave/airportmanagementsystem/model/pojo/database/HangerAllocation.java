package com.techwave.airportmanagementsystem.model.pojo.database;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity public class HangerAllocation {
    @EmbeddedId
    private AllocationKey allocationKey;
    @NotBlank(message = "Required")
    private String FromDate;
    private String ToDate;
    @Transient
    private Long airplaneId;
    @Transient
    private Long hangarId;
    @Transient
    private String status;
    @Transient
    private String hangerLocation;
}