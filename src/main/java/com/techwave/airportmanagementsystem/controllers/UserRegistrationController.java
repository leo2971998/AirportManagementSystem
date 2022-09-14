package com.techwave.airportmanagementsystem.controllers;

import com.techwave.airportmanagementsystem.model.pojo.registration.RegistrationService;
import com.techwave.airportmanagementsystem.model.pojo.user.Login;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( path = "api/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private RegistrationService registrationService;
    @PostMapping()
    public String register(@RequestBody Login login) {
        return registrationService.register(login);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
