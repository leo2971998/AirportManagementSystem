package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.database.HangerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HangerRepository extends JpaRepository<HangerDetails, Long> {
    Optional<HangerDetails> findByEmail(String Email);
    Optional<HangerDetails> findBySsNo(String SsNo);
    Optional<HangerDetails> findByMobileNo(String MobileNo);
}
