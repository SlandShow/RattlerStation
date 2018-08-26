package com.slandshow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // JSP views
    private static final String MAIN_PAGE = "main-menu";

    // Handle root request
    @RequestMapping("/")
    public String showHomePage() {
        return MAIN_PAGE;
    }

}
