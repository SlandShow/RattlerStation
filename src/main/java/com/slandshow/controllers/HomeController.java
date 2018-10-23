package com.slandshow.controllers;

import com.slandshow.service.MessageQueueService;
import com.slandshow.utils.JspFormNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
public class HomeController {

    // Handle root & home request
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage() {
        return JspFormNames.MAIN_PAGE;
    }

}
