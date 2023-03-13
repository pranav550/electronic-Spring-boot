package com.lcwd.mvc.SpringMvcProject.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperMan {
    @RequestMapping("/about")
    public String aboutRequestHandler(){
        System.out.println("Processing About Request");
        return "about";
    }
    @RequestMapping("/services")
    public String serviceRequestHandler(){
        System.out.println("Processing About Request");
        return "services";
    }
}
