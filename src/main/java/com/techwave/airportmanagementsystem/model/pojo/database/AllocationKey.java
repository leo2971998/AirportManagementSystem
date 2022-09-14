package com.techwave.airportmanagementsystem.model.pojo.database;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable

public class AllocationKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "HangerId")
    private HangerDetails HangerId;
    @OneToOne
    @JoinColumn(name = "PlaneId")
    private Airplane PlaneId;

    public AllocationKey() {
        super();
    }

    public AllocationKey(HangerDetails hangerId, Airplane planeId) {
        super();
        HangerId = hangerId;
        PlaneId = planeId;
    }

    public HangerDetails getHangerId() {
        return HangerId;
    }

    public void setHangerId(HangerDetails hangerId) {
        HangerId = hangerId;
    }

    public Airplane getPlaneId() {
        return PlaneId;
    }

    public void setPlaneId(Airplane planeId) {
        PlaneId = planeId;
    }
}
