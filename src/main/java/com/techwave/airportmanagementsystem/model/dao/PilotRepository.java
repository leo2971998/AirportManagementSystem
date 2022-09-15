package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface PilotRepository extends JpaRepository<Pilot, Long> {
    Optional<Pilot> findByEmail(String Email);
    Optional<Pilot> findByMobileNo(String Email);
    Optional<Pilot> findBySsNo(String Email);
    Optional<Pilot> findByLicenseNo(String Email);
}
