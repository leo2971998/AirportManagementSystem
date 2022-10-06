package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;
import com.techwave.airportmanagementsystem.model.pojo.database.HangerDetails;
import com.techwave.airportmanagementsystem.model.pojo.database.Pilot;
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

    @Override
    public String AddPlane(Airplane A) {
        airplaneRepository.save(A);
        return String.format("Plane %s added successfully", A.getPlaneId());
    }
    @Override
    public String AddPilot(Pilot P) {
        pilotRepository.save(P);
        return String.format("Pilot %s added successfully", P.getPilotId());
    }

    @Override
    public String AddHanger(HangerDetails H) {
        hangerRepository.save(H);
        return String.format("Hanger %s added successfully", H.getHangerId());
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

}
