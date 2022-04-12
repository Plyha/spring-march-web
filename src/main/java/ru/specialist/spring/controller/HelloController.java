package ru.specialist.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String param,
                        ModelMap model){
        model.put("name", param != null ? param : "Default Name");
        return "hello-page";
    }

}
