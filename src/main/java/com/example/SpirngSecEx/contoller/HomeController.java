package com.example.SpirngSecEx.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String homePage(){
        return "page_layout/layout";
    }
}




