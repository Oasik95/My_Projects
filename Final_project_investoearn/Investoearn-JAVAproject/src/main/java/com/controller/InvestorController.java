package com.controller;

import com.domain.*;
import com.service.AuthorityService;
import com.service.EntrepreneurIdeaService;
import com.service.InvestorService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/investor")
public class InvestorController {

    private EntrepreneurIdeaService entrepreneurIdeaService;

    private AuthorityService authorityService;
    private UserService userService;
    private InvestorService investorService;

    public InvestorController(EntrepreneurIdeaService entrepreneurIdeaService,InvestorService investorService,UserService userService,AuthorityService authorityService)
    {
        this.entrepreneurIdeaService=entrepreneurIdeaService;
        this.investorService=investorService;
        this.userService=userService;
        this.authorityService=authorityService;
    }


    @RequestMapping("/home")
    public String HOME(Principal principal,Model model) {
        Investor investor=investorService.findByUserName(principal.getName());
        model.addAttribute("id",investor.getId());
        return "investorhome";
    }


    @RequestMapping("/show")
    public String show()
    {
        return "register2";
    }



    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("investor") Investor investor,
                         @ModelAttribute("user") User user ,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "register2";
        } else {

            investorService.insert(investor);


            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(authorityService.get(3L));
            user.setAuthorities(authorityList);
            userService.insert(user);
            return "login";
        }
    }

    @RequestMapping("/investorview")
    public String investor(Model model) {
        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAllByStutas("Approved");
        model.addAttribute("historyList",all);
        return "investorview";
    }


    @RequestMapping(value = "/approve/{id}")
    public String approveIdea(@PathVariable Long id, Principal principal){
        EntrepreneurIdea entrepreneurIdea = entrepreneurIdeaService.get(id);

        Investor investor=investorService.findByUserName(principal.getName());
        entrepreneurIdea.setInvestor(investor);
        entrepreneurIdea.setStutas("Invested");
        entrepreneurIdeaService.update(entrepreneurIdea);
        return "redirect:/investor/investorview";

    }



    @RequestMapping("/investedproposal")
    public String investedproposal( Principal principal,Model model) {
        List<EntrepreneurIdea> all = entrepreneurIdeaService.getAllByInvestorName(principal.getName());
        model.addAttribute("historyList",all);
        return "investedproposal";
    }

    @RequestMapping("/profile/{id}")
    public String get(@ModelAttribute(" investor") Investor investor, @PathVariable Long id,Model model) {
        investor = investorService.get(id);
        model.addAttribute("username",investor.getUsername() );
        model.addAttribute("email",investor.getEmail() );
        model.addAttribute("phonenumber",investor.getPhonenumber() );
        model.addAttribute("dob",investor.getDob() );
        model.addAttribute("nid",investor.getNid() );
        model.addAttribute("gender",investor.getGender() );
        return "InvestorProfile";
    }
}
