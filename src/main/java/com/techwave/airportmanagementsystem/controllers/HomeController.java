package com.techwave.airportmanagementsystem.controllers;

import com.techwave.airportmanagementsystem.model.dao.DatabaseDao;
import com.techwave.airportmanagementsystem.model.dao.RegistrationDao;
import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;
import com.techwave.airportmanagementsystem.model.pojo.user.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    RegistrationDao registrationDao;
    @Autowired
    DatabaseDao databaseDao;

    @RequestMapping("/")
    public String Home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin";
        } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("MANAGER")))
            return "redirect:/manager";
        else return "Home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "Admin";
    }

    @RequestMapping("/manager")
    public String manager() {
        return "Manager";
    }

    @RequestMapping("/register")
    public String addVendor(Model M) {
        M.addAttribute("Login", new Login());
        return "Register";
    }

    @RequestMapping("/register/save")
    public String getUserDetails(@Valid @ModelAttribute("Login") Login login, BindingResult BS, Model M) {
        if (BS.hasErrors()) {
            return "Register";
        } else {
            String msg = registrationDao.AddUser(login);
            M.addAttribute("msg", msg);
            return "Admin";
        }
    }
    @RequestMapping("/addplane")
    public String addPlane(Model M) {
        M.addAttribute("Airplane", new Airplane());
        return "AddPlane";
    }
    @RequestMapping("/addplane/create")
    public String createPlane(@Valid @ModelAttribute("Airplane") Airplane A, BindingResult BS, Model M) {
        if (BS.hasErrors()) {
            return "AddPlane";
        }
        else {
            String msg = "";
            if (databaseDao.RegNoExists(A.getRegNo())) {
                msg = "Registration Number Already Taken";
            }
            else {
                msg = databaseDao.AddPlane(A);
            }
            M.addAttribute("msg", msg);
            return "AddPlane";
        }
    }
}
