package com.controller;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;
import com.domain.Investor;
import com.service.EntrepreneurIdeaService;
import com.service.EntrepreneurService;
import com.service.InvestorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private EntrepreneurIdeaService entrepreneurIdeaService;

    private EntrepreneurService entrepreneurService;

    private InvestorService investorService;


    public AdminController(EntrepreneurIdeaService entrepreneurIdeaService,EntrepreneurService entrepreneurService,InvestorService investorService)
    {
        this.entrepreneurIdeaService=entrepreneurIdeaService;

        this.investorService=investorService;

        this.entrepreneurService=entrepreneurService;


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

    @RequestMapping("/allEN")
    public String allEN(Model model) {
        List<Entrepreneur> all = entrepreneurService.getAllEN();
        model.addAttribute("ENList",all);
        return "allEN";
    }

    @RequestMapping("/allinvestor")
    public String allinvestor(Model model) {
        List<Investor> all = investorService.getAllinvestor();
        model.addAttribute("investorlist",all);
        return "allinvestor";
    }
    @RequestMapping(value = "/approve/{id}")
    public String approveIdea(@PathVariable Long id){
        EntrepreneurIdea entrepreneurIdea = entrepreneurIdeaService.get(id);
        entrepreneurIdea.setStutas("Approved");
        entrepreneurIdeaService.update(entrepreneurIdea);
     return "redirect:/admin/allproposal";

    }

    @RequestMapping(value = "/reject/{id}")
    public String RejectIdea(@PathVariable Long id){
        EntrepreneurIdea entrepreneurIdea = entrepreneurIdeaService.get(id);
        entrepreneurIdea.setStutas("Rejected");
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
