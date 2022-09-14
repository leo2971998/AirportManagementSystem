package com.techwave.airportmanagementsystem.model.pojo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Login, Long>  {
    Optional<Login> findByEmail(String Email);

    @Transactional
    @Modifying
    @Query("UPDATE Login a " +
            "SET a.Enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
