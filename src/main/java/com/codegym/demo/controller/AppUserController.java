package com.codegym.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class AppUserController {

    @GetMapping("")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

    @GetMapping("/shop")
    public ModelAndView shop(){
        return new ModelAndView("shop");
    }

    @GetMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("user");
    }

    @PostMapping("/error-403")
    public ModelAndView e403(){
        return new ModelAndView("error-403");
    }

    @PostMapping("/error-404")
    public ModelAndView e404(){
        return new ModelAndView("error-404");
    }

}
