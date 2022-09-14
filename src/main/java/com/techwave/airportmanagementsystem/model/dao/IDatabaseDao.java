package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;

public interface IDatabaseDao {
    String AddPlane(Airplane A);
    public boolean RegNoExists(String Regno);
}
