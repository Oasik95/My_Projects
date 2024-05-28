package com.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/index")
    public String index()
    {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String role = loggedInUser.getAuthorities().toArray()[0].toString();
        if(role.equals("ROLE_ADMIN"))
        {
            return "redirect:/admin/home";

        } else if (role.equals("ROLE_ENTREPRENEUR")) {
            return "redirect:/entrepreneur/home";

        }
        else
        {
            return "redirect:/investor/home";
        }

    }
}
