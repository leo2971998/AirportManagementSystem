package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseDao implements IDatabaseDao {
    @Autowired
    AirplaneRepository airplaneRepository;

    @Autowired
    PilotRepository pilotRepository;

    @Autowired
    HangerRepository hangerRepository;

    @Autowired
    HangerAllocationRepository hangerAllocationRepository;
    @Override
    public String AddPlane(Airplane A) {
        A.setStatus("Available");
        airplaneRepository.save(A);
        return String.format("Plane %s added successfully", A.getPlaneId());
    }
    @Override
    public String AddPilot(Pilot P) {
        Airplane A = airplaneRepository.findById(P.getAirplaneId()).get();
        P.setPlaneId(A);
        pilotRepository.save(P);
        return String.format("Pilot %s added successfully", P.getPilotId());
    }

    @Override
    public String AddHanger(HangerDetails H) {
        H.setStatus("Available");
        hangerRepository.save(H);
        return String.format("Hanger %s added successfully", H.getHangerId());
    }
    @Override
    public String AddHangerAllocation(HangerAllocation H) {
        Airplane oldAirplane = airplaneRepository.findById(H.getAirplaneId()).get();
        oldAirplane.setStatus("Booked");
        airplaneRepository.save(oldAirplane);
        HangerDetails oldHanger = hangerRepository.findById(H.getHangarId()).get();
        oldHanger.setStatus("Booked");
        hangerRepository.save(oldHanger);
        Airplane airplane = airplaneRepository.findById(H.getAirplaneId()).get();
        HangerDetails hangerDetails = hangerRepository.findById(H.getHangarId()).get();
        AllocationKey allocationKey = new AllocationKey();
        allocationKey.setAirplane(airplane);
        allocationKey.setHangerId(hangerDetails);
        H.setAllocationKey(allocationKey);
        hangerAllocationRepository.save(H);
        return String.format("Hanger allocated for the plane %s from date %s to date %s", H.getAirplaneId(), H.getFromDate(), H.getToDate());
    }
    @Override
    public boolean RegNoExists(String Regno) {
        return airplaneRepository.findByRegNo(Regno).isPresent();
    }
    @Override
    public boolean EmailExists(String Email) {
        return airplaneRepository.findByEmail(Email).isPresent();
    }

    @Override
    public boolean SsNoExists(String SsNo) {
        return pilotRepository.findBySsNo(SsNo).isPresent();
    }

    @Override
    public boolean PilotEmailExists(String Email) {
        return pilotRepository.findByEmail(Email).isPresent();
    }

    @Override
    public boolean LicenseNoExists(String LicenseNo) {
        return pilotRepository.findByLicenseNo(LicenseNo).isPresent();
    }

    @Override
    public boolean MobileNoExists(String MobileNo) {
        return pilotRepository.findByMobileNo(MobileNo).isPresent();
    }

    @Override
    public boolean HangerSsNoExists(String SsNo) {
        return hangerRepository.findBySsNo(SsNo).isPresent();
    }

    @Override
    public boolean ManagerEmailExists(String Email) {
        return hangerRepository.findByEmail(Email).isPresent();
    }

    @Override
    public boolean ManagerMobileNoExists(String MobileNo) {
        return hangerRepository.findByMobileNo(MobileNo).isPresent();
    }
    @Override
    public List<Airplane> loadAirplanes() {
        return airplaneRepository.findAll();
    }
    @Override
    public Airplane getAirPlaneByID(Long airplaneId) {
        return airplaneRepository.findById(airplaneId).stream().collect(Collectors.toList()).get(0);
    }
    @Override
    public List<HangerDetails> loadHangars() {
        return hangerRepository.findAll();
    }
    @Override
    public List<HangerDetails> loadHangarAllos() {
        List<HangerAllocation> hangerAllocationList = hangerAllocationRepository.findAll();
        List<HangerDetails> result = hangerRepository.findAll();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < hangerAllocationList.size(); j++) {
                if (result.get(i).getHangerId() == hangerAllocationList.get(j).getAllocationKey().getHangerId().getHangerId()) {
                    HangerDetails temp = result.get(i);
                    temp.setPlaneId(hangerAllocationList.get(j).getAllocationKey().getAirplane().getPlaneId());
                    temp.setFromDate(hangerAllocationList.get(j).getFromDate());
                    temp.setToDate(hangerAllocationList.get(j).getToDate());
                    result.set(i,temp);
                }
            }
        }
        return result;
    }
}
