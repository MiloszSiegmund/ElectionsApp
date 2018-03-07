package com.app.controller;

import com.app.model.Candidate;
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
@RequestMapping ("/candidate")
public class CandidateController {
    private MyService myService;

    public CandidateController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping (value = "/add")
    public String candidateAddGet(Model model) {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        model.addAttribute("error", new LinkedHashMap<>());
        return "/insert";
    }
    @GetMapping (value = "/select_all")
    public String candidateSelectAll(Model model){
        model.addAttribute("candidate",myService.getAllCandidates());
        return "/select_all";
    }
    @PostMapping (value = "/add")
    public String candidateAddPost(Candidate candidate, Model model, HttpServletRequest request){
        model.addAttribute("candidate", candidate);
        myService.saveCandidate(candidate);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/{id}")
    public String candidateDelete(@PathVariable Long id){
        myService.deleteCandidate(id);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/details/{id}")
    public String candidateDetails(@PathVariable Long id, Model model) {
        Optional<Candidate> candidateOp = myService.getCandidateById(id);
        if (candidateOp.isPresent()){
            model.addAttribute("candidate",candidateOp.get());
            return "/details";
        }
        return "redirect:/select_all";
    }
    @GetMapping (value = "/update/{id}")
    public String candidateUpdateGet(@PathVariable Long id, Model model) {
        Optional<Candidate> candidateOp = myService.getCandidateById(id);
        if (candidateOp.isPresent()){
            model.addAttribute("candidate",candidateOp.get());
            return "/update";
        }
        return "redirect:/select_all";
    }
    @PostMapping (value = "/update/{id}")
    public String candidateUpdatePost( Candidate candidate, Model model,HttpServletRequest request){
        if (candidate != null){
            myService.modifyCandidate(candidate);
        }
        return "redirect:/select_all";
    }

}
