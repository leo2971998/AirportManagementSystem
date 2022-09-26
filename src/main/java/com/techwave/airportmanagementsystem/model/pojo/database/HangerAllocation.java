package com.techwave.airportmanagementsystem.model.pojo.database;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity
public class HangerAllocation {
    @EmbeddedId
    private AllocationKey allocationKey;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate FromDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ToDate;

}