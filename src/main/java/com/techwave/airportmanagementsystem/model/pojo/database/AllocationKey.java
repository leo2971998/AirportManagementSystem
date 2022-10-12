package com.techwave.airportmanagementsystem.model.pojo.database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class AllocationKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "hangerId")
    private HangerDetails hangerId;
    @OneToOne
    @JoinColumn(name="PlaneId")
    private Airplane airplane;

}