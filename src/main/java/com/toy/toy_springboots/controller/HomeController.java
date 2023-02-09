package com.toy.toy_springboots.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView main(ModelAndView modelAndView){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
        String username = ((UserDetails)principal).getUsername();
        } else {
        String username = principal.toString();
        }

        System.out.println(((UserDetails)principal).getUsername());

        String viewName = "/main";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
