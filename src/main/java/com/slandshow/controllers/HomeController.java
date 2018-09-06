package com.slandshow.controllers;

import com.slandshow.utils.JspFormNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    // Handle root & home request
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage() {
        return JspFormNames.MAIN_PAGE;
    }

}
