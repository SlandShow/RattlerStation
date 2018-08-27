package com.slandshow.controllers;

import com.slandshow.utils.JspFormNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // Handle root request
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return JspFormNames.MAIN_PAGE;
    }

}
