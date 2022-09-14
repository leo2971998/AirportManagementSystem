package com.techwave.airportmanagementsystem.model.dao;

import com.techwave.airportmanagementsystem.model.pojo.user.Login;
import com.techwave.airportmanagementsystem.model.pojo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RegistrationDao implements IRegistrationDao {
    @Autowired
    RestTemplate restTemplate;

    public String url = "http://localhost:9095/";

    private UserRepository userRepository;
    @Override
    public String AddUser(Login login) {
        return restTemplate.postForObject(url + "api/registration", login, String.class);
    }
}
