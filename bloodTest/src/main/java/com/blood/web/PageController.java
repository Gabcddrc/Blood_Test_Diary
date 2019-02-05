package com.blood.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }
    @GetMapping(value="/home")
    public String home(){
        return "/home";
    }
    @GetMapping(value="/sample")
    public String sample(){
        return "/sample";
    }
}
