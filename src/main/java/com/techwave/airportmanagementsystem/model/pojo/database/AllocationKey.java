package com.techwave.airportmanagementsystem.model.pojo.database;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "HangerId",
                query = "Select Hanger_Id From Hanger_Details;"
        ),
        @NamedNativeQuery(
                name = "PlaneId",
                query = "Select Plane_Id From Airplane;"
        )
})
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
