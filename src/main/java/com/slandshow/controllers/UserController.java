package com.slandshow.controllers;

import com.slandshow.DTO.UserDTO;
import com.slandshow.service.SecureService;
import com.slandshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecureService secureService;


    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }


    public String registration() {

        return "registration";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {

        return "admin";
    }


/*
    @PostMapping("/registration")
    public void registration(@RequestBody UserDTO userDTO) throws IOException {
        userService.registration(userDTO);
    }*/

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
/*
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(URLs.GET_USERS_TICKETS)
    public ResponseEntity<?> showTrips() {
        List<TicketInfoDTO> tickets = ticketService.getAuthenticatedUserTicket();
        return ResponseEntity.ok(tickets);
    }

    /*
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(URLs.AUDIT)
    public ResponseEntity<?> getAuditInfo() {
        List<AuditDTO> auditDTOList = auditService.getAuditsInfo();
        return ResponseEntity.ok(auditDTOList);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(URLs.DOWNLOAD)
    public void downloadTicket(HttpServletResponse response,
                               @PathVariable Long id) throws IOException, DocumentException {
        Ticket ticket = ticketService.getById(id);
        File file = ticketBuilderPDF.createPDF(ticket);
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        response.setContentType(mimeType);
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping(URLs.AUTH)
    public ResponseEntity<?> authInfo(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = secureService.authenticate(userDTO);
        return ResponseEntity.ok(authenticationToken.getAuthorities());
    } */
}
