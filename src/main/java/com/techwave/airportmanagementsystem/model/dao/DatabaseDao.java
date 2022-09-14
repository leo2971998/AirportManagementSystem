package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseDao implements IDatabaseDao {
    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public String AddPlane(Airplane A) {
        airplaneRepository.save(A);
        return String.format("Plane %s added successfully", A.getPlaneId());
    }
    @Override
    public boolean RegNoExists(String Regno) {
        return airplaneRepository.findByRegNo(Regno).isPresent();
    }
}
