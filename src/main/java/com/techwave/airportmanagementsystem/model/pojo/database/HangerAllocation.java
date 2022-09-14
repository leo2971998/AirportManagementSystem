package com.techwave.airportmanagementsystem.model.pojo.database;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity

public class HangerAllocation {
    @EmbeddedId
    private AllocationKey allocationKey;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate FromDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ToDate;
    public HangerAllocation() {}

    public HangerAllocation(AllocationKey allocationKey, LocalDate fromDate, LocalDate toDate) {
        super();
        this.allocationKey = allocationKey;
        FromDate = fromDate;
        ToDate = toDate;
    }

    public AllocationKey getAllocationKey() {
        return allocationKey;
    }

    public void setAllocationKey(AllocationKey allocationKey) {
        this.allocationKey = allocationKey;
    }

    public LocalDate getFromDate() {
        return FromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        FromDate = fromDate;
    }

    public LocalDate getToDate() {
        return ToDate;
    }

    public void setToDate(LocalDate toDate) {
        ToDate = toDate;
    }
}