package com.controller;

import com.domain.*;
import com.service.AuthorityService;
import com.service.EntrepreneurIdeaService;
import com.service.EntrepreneurService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entrepreneur")
public class EntrepreneurController {

    private EntrepreneurService entrepreneurService;
    private UserService userService;

    private AuthorityService authorityService;

    private EntrepreneurIdeaService entrepreneurIdeaService;

    public EntrepreneurController(EntrepreneurService entrepreneurService, UserService userService, AuthorityService authorityService,EntrepreneurIdeaService entrepreneurIdeaService) {
        this.entrepreneurService = entrepreneurService;
        this.userService = userService;
        this.authorityService = authorityService;
        this.entrepreneurIdeaService =entrepreneurIdeaService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home(Principal principal,Model model) {
        Entrepreneur entrepreneur=entrepreneurService.findByUserName(principal.getName());
        model.addAttribute("id",entrepreneur.getId());
        return "entrepreneurHome";
    }




    @RequestMapping("/show")
    public String show(Model model) {
        Entrepreneur entrepreneur = new Entrepreneur();
        model.addAttribute("entrepreneur", entrepreneur);
        return "register";
    }



    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("entrepreneur") Entrepreneur entrepreneur,
                         @ModelAttribute("user")User user ,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "register";
        } else {

            entrepreneurService.insert(entrepreneur);


            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(authorityService.get(2L));
            user.setAuthorities(authorityList);
            userService.insert(user);
            return "login";
        }
    }
    @RequestMapping("/resetpass")
    public String resetpass(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {

            return "forgotpass";

        } else {
            User user1 = userService.getByUsername(user.getUsername());
            if(user!=null)
            {
                user1.setPassword(user.getPassword());

                userService.update(user1);

            }
            return "login";
        }
    }


    @RequestMapping("/creatidea")
    public String submitida(@Valid @ModelAttribute("entrepreneurIdea") EntrepreneurIdea entrepreneurIdea,

                         BindingResult bindingResult,Principal principal) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "addidea";
        }
        else {
            Entrepreneur entrepreneur=entrepreneurService.findByUserName(principal.getName());
            entrepreneurIdea.setEntrepreneur(entrepreneur);
            entrepreneurIdeaService.insert(entrepreneurIdea);
            return "entrepreneurHome";
        }
    }

    @RequestMapping("/ideahistory")
    public String getAll(Principal principal, Model model) {

        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAllByUserName(principal.getName());
        model.addAttribute("historyList",all);

        return "history";
    }

    @RequestMapping("/profile/{id}")
    public String get(@ModelAttribute(" entrepreneur") Entrepreneur entrepreneur, @PathVariable Long id,Model model) {
        entrepreneur = entrepreneurService.get(id);
        model.addAttribute("username",entrepreneur.getUsername() );
        model.addAttribute("email",entrepreneur.getEmail() );
        model.addAttribute("phonenumber",entrepreneur.getPhonenumber() );
        model.addAttribute("dob",entrepreneur.getDob() );
        model.addAttribute("nid",entrepreneur.getNid() );
        model.addAttribute("gender",entrepreneur.getGender() );
        return "EntrepreneurProfile";
    }


}

