package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;
import com.techwave.airportmanagementsystem.model.pojo.database.HangerDetails;
import com.techwave.airportmanagementsystem.model.pojo.database.Pilot;

import java.util.List;

public interface IDatabaseDao {
    String AddPlane(Airplane A);

    String AddPilot(Pilot P);
    String AddHanger(HangerDetails H);

    boolean RegNoExists(String Regno);

    boolean EmailExists(String Email);

    boolean SsNoExists(String SsNo);

    boolean PilotEmailExists(String Email);

    boolean LicenseNoExists(String LicenseNo);

    boolean MobileNoExists(String MobileNo);

    boolean HangerSsNoExists(String SsNo);

    boolean ManagerEmailExists(String Email);

    boolean ManagerMobileNoExists(String MobileNo);

    List<Airplane> loadAirplanes();
}
