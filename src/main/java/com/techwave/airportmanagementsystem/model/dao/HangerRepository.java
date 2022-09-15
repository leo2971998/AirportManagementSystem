package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.HangerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HangerRepository extends JpaRepository<HangerDetails, Long> {
    Optional<HangerDetails> findByEmail(String Email);
    Optional<HangerDetails> findBySsNo(String SsNo);
    Optional<HangerDetails> findByMobileNo(String MobileNo);
}
