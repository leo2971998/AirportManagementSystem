package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.user.Login;

public interface IRegistrationDao {
    String AddUser(Login login);
}
