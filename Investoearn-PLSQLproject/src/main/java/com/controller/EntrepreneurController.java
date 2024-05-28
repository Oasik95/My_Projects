package com.controller;

import com.domain.*;
import com.service.AuthorityService;
import com.service.EntrepreneurIdeaService;
import com.service.EntrepreneurService;
import com.service.UsersService;
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
    private UsersService usersService;

    private AuthorityService authorityService;

    private EntrepreneurIdeaService entrepreneurIdeaService;

    public EntrepreneurController(EntrepreneurService entrepreneurService, UsersService usersService, AuthorityService authorityService, EntrepreneurIdeaService entrepreneurIdeaService) {
        this.entrepreneurService = entrepreneurService;
        this.usersService = usersService;
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

    @RequestMapping("/addidea")
    public String addidea() {
        return "addidea";
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



    @RequestMapping(value = "/submit" ,method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("entrepreneur") Entrepreneur entrepreneur,
                         @ModelAttribute("users") Users users ,
                         BindingResult bindingResult) throws SQLException{

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "register";
        } else {

            entrepreneurService.insert(entrepreneur);


            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(authorityService.get(2L));
            users.setAuthorities(authorityList);
            usersService.insert(users);
            return "login";
        }
    }
    @RequestMapping("/resetpass")
    public String resetpass(@Valid @ModelAttribute("users") Users users,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {

            return "forgotpass";

        } else {
            Users users1 = usersService.getByUsername(users.getUsername());
            if(users !=null)
            {
                users1.setPassword(users.getPassword());

                usersService.update(users1);

            }
            return "login";
        }
    }


    @RequestMapping("/creatidea")
    public String submitida(@Valid @ModelAttribute("entrepreneurIdea") EntrepreneurIdea entrepreneurIdea,

                         BindingResult bindingResult,Principal principal)   {
        if (bindingResult.hasErrors()) {
            return "addidea";
        }
        else {
            try {
                Entrepreneur entrepreneur=entrepreneurService.findByUserName(principal.getName());
                entrepreneurIdea.setEntrepreneur(entrepreneur);
                entrepreneurIdeaService.insert(entrepreneurIdea);
                return "entrepreneurHome";

            }catch (Exception e){

                return "addidea";
            }

        }
    }

    @RequestMapping(value = "/deleteide/{id}")
    public String deleteida(@PathVariable Long id){

            EntrepreneurIdea entrepreneurIdea = entrepreneurIdeaService.get(id);
            entrepreneurIdeaService.delete(entrepreneurIdea);
             return "redirect:/entrepreneur/ideahistory";
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

