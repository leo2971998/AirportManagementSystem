package com.techwave.airportmanagementsystem.model.pojo.database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class AllocationKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hanger_Id")
    private HangerDetails hangerId;
    @OneToOne
    @JoinColumn(name="PlaneId")
    private Airplane airplane;

}