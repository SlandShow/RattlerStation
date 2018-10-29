package com.slandshow.controllers;

import com.slandshow.DTO.*;
import com.slandshow.exceptions.InvalidUserRegistrationException;
import com.slandshow.models.Role;
import com.slandshow.models.Schedule;
import com.slandshow.models.User;
import com.slandshow.service.*;
import com.slandshow.utils.JspFormNames;
import com.slandshow.utils.UtilsManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SecureService secureService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration/confirm")
    public String registration(@ModelAttribute UserDTO userDTO) {
        String status = "";
        try {
            userService.registration(userDTO);

            status = "succesful";
        } catch (IOException | InvalidUserRegistrationException e) {
            status = "problem";
            e.printStackTrace();
        }
        return "login";
    }

    @GetMapping("/registration-result")
    public String result() {
        return "registration-result";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/adminService")
    public String adminServiceMenu() {
        return "admin-service-menu";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "adding-user-form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addUser")
    public String permitNewUser(@ModelAttribute UserDTO userDTO, @RequestParam("role") String role) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(UtilsManager.encodePassword(userDTO.getPassword()));

        long roleId = -1;

        if (role.equals("USER_ROLE")) roleId = 1;
        else if (role.equals("ADMIN_ROLE")) roleId = 2;
        else if (role.equals("MANAGER_ROLE")) roleId = 3;

        userService.add(user);

        long correctUserId = userService.findUserByEmail(userDTO.getLogin()).getId();

        userService.addUserRole(correctUserId, roleId);

        return "user-added";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/deleteUser")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());

        return "user-list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/deleteUser", params = "id")
    public String permitUserDeleting(@ModelAttribute User user, @RequestParam(value = "id") Long id) {
        userService.deleteUserRole(id);
        userService.remove(user);

        LOGGER.info("USER READY TO BE DELETED: " + user);

        return "admin-service-menu";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/managerTools")
    public String managerMenu() {
        return "manager-menu";
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/home/profile/get")
    public ResponseEntity<?> getProfile() {
        UserDTO userDTO = userService.findAuthenticatedUserDTO();
        return ResponseEntity.ok(userDTO);
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/home/update")
    public void updateUser(@RequestBody UserDTO userDTO) throws ParseException {
        userService.updateProfile(userDTO);
    }
}
