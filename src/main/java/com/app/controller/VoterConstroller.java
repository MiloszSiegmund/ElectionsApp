package com.app.controller;

import com.app.model.Voter;
import com.app.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Optional;

@Controller
@RequestMapping ("/voter")
public class VoterConstroller {
    private MyService myService;

    public VoterConstroller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping (value = "/add")
    public String voterGet(Model model){
        Voter voter = new Voter();
        model.addAttribute("voter", voter);
        model.addAttribute("errors", new LinkedHashMap<>());
        return "/insert";
    }
    @PostMapping (value = "/add")
    public String voterPost(Voter voter, Model model, HttpServletRequest request){
        model.addAttribute("voter",voter);
        myService.saveVoter(voter);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/select_all")
    public String voterAll(Model model){
        model.addAttribute("voters",myService.getAllVoters());
        return "redirect:/select_all";
    }
    @GetMapping (value = "/{id}")
    public String voterDelete(@PathVariable Long id){
        myService.deleteVoter(id);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/details/{id}")
    public String voterDetails(@PathVariable Long id, Model model){
        Optional<Voter> voterOp = myService.getVoterById(id);
        if (voterOp.isPresent()){
            model.addAttribute("voter",voterOp.get());
            return "/details";
        }
        return "redirect:/select_all";
    }
    @GetMapping (value = "/update/{id}")
    public String updateVoterGet(@PathVariable Long id, Model model){
        Optional<Voter> voterOp = myService.getVoterById(id);
        if (voterOp.isPresent()){
            model.addAttribute("voter",voterOp.get());
            return "/update";
        }
        return "redirect:/select_all";
    }
    @PostMapping (value = "/update/{id}")
    public String updateVoterPost(Voter voter, Model model, HttpServletRequest request){
        if (voter != null){
            myService.modifyVoter(voter);
        }
        return "redirect:/select_all";
    }
}
