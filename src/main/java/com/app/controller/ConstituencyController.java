package com.app.controller;

import com.app.model.Constituency;
import com.app.service.MyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
@RequestMapping ("/constituency")
public class ConstituencyController {

    private MyService myService;

    public ConstituencyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping (value = "/add")
    public String constituencyGet(Model model){
        Constituency constituency = new Constituency();
        model.addAttribute("constituency",constituency);
        model.addAttribute("errors",new LinkedHashMap<>());
        return "/insert";
    }
    @PostMapping (value = "/add")
    public String constituencyPost(Constituency constituency, Model model, HttpServletRequest request){
        model.addAttribute("constituency",constituency);
        myService.saveConstituency(constituency);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/select_all")
    public String constituencyAll(Model model){
        model.addAttribute("candidates",myService.getAllCandidates());
        return "redirect:/select_all";
    }
    @GetMapping (value = "{id}")
    public String constituencyDelete(@PathVariable Long id){
        myService.deleteConstituency(id);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/details/{id}")
    public String constituencyDetails(@PathVariable Long id, Model model){
        Optional<Constituency> constituencyOp = myService.getConstituencyByIdl(id);
        if (constituencyOp.isPresent()){
            model.addAttribute("constituency",constituencyOp.get());
            return "/details";
        }
        return "redirect:/select_all";
    }
    @GetMapping (value = "/update/{id}")
    public String constituencyUpdateGet(@PathVariable Long id, Model model){
        Optional<Constituency> constituencyOp = myService.getConstituencyByIdl(id);
        if (constituencyOp.isPresent()){
            model.addAttribute("constituency",constituencyOp.get());
            return "/update";
        }
        return "redirect:/select_all";
    }
    @PostMapping (value = "/update/{id}")
    public String constituencyUpdatePost(Constituency constituency, Model model, HttpServletRequest request){
        if(constituency != null){
            myService.modifyConstituency(constituency);
        }
        return "redirect:/select_all";
    }
}
