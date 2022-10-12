package com.techwave.airportmanagementsystem.controllers;

import com.techwave.airportmanagementsystem.model.dao.DatabaseDao;
import com.techwave.airportmanagementsystem.model.dao.RegistrationDao;
import com.techwave.airportmanagementsystem.model.pojo.database.Airplane;
import com.techwave.airportmanagementsystem.model.pojo.database.HangerAllocation;
import com.techwave.airportmanagementsystem.model.pojo.database.HangerDetails;
import com.techwave.airportmanagementsystem.model.pojo.database.Pilot;
import com.techwave.airportmanagementsystem.model.pojo.user.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    static List<Airplane> airplaneList = null;
    static List<HangerDetails> hangarList = null;
    @Autowired
    RegistrationDao registrationDao;
    @Autowired
    DatabaseDao databaseDao;

    @RequestMapping("/validatelogin")
    public String ValidateLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin";
        } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("MANAGER")))
            return "redirect:/manager";
        else return "redirect:/login";
    }

    @RequestMapping("/")
    public String Home() {
        return "Home";
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
        String msg = "";
        try {
            if (BS.hasErrors()) {
                return "Register";
            } else {
                msg = registrationDao.AddUser(login);
                M.addAttribute("msg", msg);
                return "redirect:/admin";
            }
        } catch (Exception E) {
            msg = "Email already taken";
            M.addAttribute("msg", msg);
            return "Register";
        }
    }

    @RequestMapping("/addplane")
    public String addPlane(Model M) {
        M.addAttribute("Airplane", new Airplane());
        return "AddPlane";
    }

    @RequestMapping("/addplane/create")
    @Transactional
    public String createPlane(@Valid @ModelAttribute("Airplane") Airplane A, BindingResult BS, Model M) {
        if (BS.hasErrors()) {
            return "AddPlane";
        } else {
            String msg = "";
            if (databaseDao.RegNoExists(A.getRegNo())) {
                msg = "Registration Number Already Taken";
            } else {
                if (databaseDao.EmailExists(A.getEmail())) {
                    msg = "Email Already Taken";
                } else msg = databaseDao.AddPlane(A);
            }
            M.addAttribute("msg", msg);
            return "AddPlane";
        }
    }

    @RequestMapping("/addpilot")
    public String addPilot(Model M) {
        airplaneList = databaseDao.loadAirplanes();
        M.addAttribute("AList", airplaneList);
        M.addAttribute("Pilot", new Pilot());
        return "AddPilot";
    }

    @RequestMapping("/getairplanebyid")
    public String getCustomerById(@RequestParam("airplaneId") Long airplaneID, Model M) {
        Airplane A = new Airplane();
        Pilot P = new Pilot();
        try {
            A = databaseDao.getAirPlaneByID(airplaneID);
            P.setAirplaneId(airplaneID);
            M.addAttribute("AP", A);
            M.addAttribute("Pilot", P);
            M.addAttribute("AList", airplaneList);
            return "AddPilot";
        } catch (Exception E) {
            M.addAttribute("AP", A);
            M.addAttribute("Pilot", new Pilot());
            M.addAttribute("AList", airplaneList);
            M.addAttribute("msg", "No Air Plane");
            return "AddPilot";
        }
    }

    @RequestMapping("/addpilot/create")
    public String createPilot(@Valid @ModelAttribute("Pilot") Pilot P, BindingResult BS, Model M) {
        airplaneList = databaseDao.loadAirplanes();
        M.addAttribute("AList", airplaneList);
        if (BS.hasErrors()) {
            return "AddPilot";
        } else {
            String msg = "";
            if (databaseDao.LicenseNoExists(P.getLicenseNo())) {
                msg = "License No Already Taken";
            } else {
                if (databaseDao.PilotEmailExists(P.getEmail())) {
                    msg = "Email Already Taken";
                } else if (databaseDao.SsNoExists(P.getSsNo())) {
                    msg = "Social Security Number Already Taken";
                } else if (databaseDao.MobileNoExists(P.getMobileNo())) {
                    msg = "Mobile Number Already Taken";
                } else msg = databaseDao.AddPilot(P);
            }
            M.addAttribute("msg", msg);
            return "AddPilot";
        }
    }

    @RequestMapping("/addhanger")
    public String addHanger(Model M) {
        M.addAttribute("Hanger", new HangerDetails());
        return "AddHanger";
    }

    @RequestMapping("/addhanger/create")
    public String createHanger(@Valid @ModelAttribute("Hanger") HangerDetails H, BindingResult BS, Model M) {
        if (BS.hasErrors()) {
            return "AddHanger";
        } else {
            String msg = "";
            if (databaseDao.ManagerEmailExists(H.getEmail())) {
                msg = "Email Already Taken";
            } else if (databaseDao.HangerSsNoExists(H.getSsNo())) {
                msg = "Social Security Number Already Taken";
            } else if (databaseDao.ManagerMobileNoExists(H.getMobileNo())) {
                msg = "Mobile Number Already Taken";
            } else msg = databaseDao.AddHanger(H);
            M.addAttribute("msg", msg);
            return "AddHanger";
        }
    }

    @RequestMapping("/allotplane")
    public String AllotingPlane(Model M) {
        hangarList = databaseDao.loadHangars().stream().filter(T-> T.getStatus().equals("Available")).collect(Collectors.toList());
        airplaneList = databaseDao.loadAirplanes().stream().filter(T-> T.getStatus().equals("Available")).collect(Collectors.toList());
        M.addAttribute("AList", airplaneList);
        M.addAttribute("HangerAllo", new HangerAllocation());
        M.addAttribute("hangarList", hangarList);
        return "AllocatingPlane";
    }
    @RequestMapping("/allotplane/create")
    public String CreateHangarAllocation(Model M, @RequestParam("hangarRadio") String hangarID, @Valid @ModelAttribute("HangerAllo") HangerAllocation hangerAllocation) {
        hangerAllocation.setHangarId(Long.parseLong(hangarID));
        hangarList = databaseDao.loadHangars().stream().filter(T-> T.getStatus().equals("Available")).collect(Collectors.toList());
        airplaneList = databaseDao.loadAirplanes().stream().filter(T-> T.getStatus().equals("Available")).collect(Collectors.toList());
        M.addAttribute("AList", airplaneList);
        M.addAttribute("hangarList", hangarList);
        String msg = databaseDao.AddHangerAllocation(hangerAllocation);
        M.addAttribute("msg", msg);
        return "AllocatingPlane";
    }
}
