package com.controller;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;
import com.service.AdminService;
import com.service.EntrepreneurIdeaService;
import com.service.EntrepreneurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private EntrepreneurIdeaService entrepreneurIdeaService;

    public AdminController(EntrepreneurIdeaService entrepreneurIdeaService)
    {
        this.entrepreneurIdeaService=entrepreneurIdeaService;
    }

    @RequestMapping("/home")
    public String HOME() {
        return "adminhome";
    }

    @RequestMapping("/adminprofile")
    public String profile() {
        return "adminprofile";
    }


    @RequestMapping("/allproposal")
    public String allproposal(Model model) {
        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAll();
        model.addAttribute("historyList",all);
        return "allproposal";
    }
    @RequestMapping(value = "/approve/{id}")
    public String approveIdea(@PathVariable Long id){
        EntrepreneurIdea entrepreneurIdea = entrepreneurIdeaService.get(id);
        entrepreneurIdea.setStutas("Approved");
        entrepreneurIdeaService.update(entrepreneurIdea);
     return "redirect:/admin/allproposal";

    }
    @RequestMapping("/approveproposal")
    public String approveproposal(Model model) {
        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAllByStutas("Approved");
        model.addAttribute("historyList",all);
        return "acceptedproposal";
    }

    @RequestMapping("/investedproposal")
    public String investedproposal(Model model) {
        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAllByInvest("Invested");
        model.addAttribute("historyList",all);
        return "investedproposaladminview";
    }


}
