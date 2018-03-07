package com.app.controller;

import com.app.model.City;
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
@RequestMapping ("/city")
public class CityController {
    private MyService myService;

    public CityController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping (value = "/add")
    public String cityFormGet(Model model){
        City city = new City();
        model.addAttribute("city", city);
        model.addAttribute("errors", new LinkedHashMap<>());
        return "/insert";
    }
    @GetMapping(value = "/select_all")
    public String citySelectAll(Model model){
        model.addAttribute("city",myService.getAllCities());
        return "/select_all";
    }

    @PostMapping (value = "/add")
    public String cityFormPost(City city, Model model, HttpServletRequest request){
        model.addAttribute("city",city);
        myService.saveCity(city);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/delete/{id}")
    public String cityDelete(@PathVariable Long id) {
        myService.deleteCity(id);
        return "redirect:/select_all";
    }
    @GetMapping (value = "/details/{id}")
    public String cityDetails(@PathVariable Long id, Model model){
        Optional<City> cityOp = myService.getCityById(id);
        if (cityOp.isPresent()){
            model.addAttribute("city", cityOp.get());
            return "/details";
        }
        return "redirect:/select_all";
    }
    @GetMapping (value = "/update/{id}")
    public String cityUpdateGet(@PathVariable Long id, Model model){
        Optional<City> cityOp = myService.getCityById(id);
        if (cityOp.isPresent()){
            model.addAttribute("city", cityOp.get());
            return "/update";
        }
        return "redirect:/select_all";
    }
    @PostMapping (value = "/update/{id}")
    public String cityUpdatePost(City city,Model model,HttpServletRequest request){
        if (city != null){
            myService.modifyCity(city);
        }
        return "redirect:/select_all";
    }

}
