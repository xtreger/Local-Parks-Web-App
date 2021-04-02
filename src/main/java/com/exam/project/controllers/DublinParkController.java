package com.exam.project.controllers;

import com.exam.project.models.DublinPark;
import com.exam.project.services.DublinParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DublinParkController {

    @Autowired
    private DublinParkService dublinParkService;

    @GetMapping("/dublinPark")
    public String viewDublinPark(Model model) {
        dublinParkService.addAllDublinPark();
        model.addAttribute("dublinParkList", dublinParkService.getAllDublinPark());
        return "dublinPark";
    }

    @GetMapping("/showNewDublinParkForm")
    public String showNewDublinParkForm(Model model) {
        DublinPark dublinPark = new DublinPark();
        model.addAttribute("dublinPark", dublinPark);
        return "addDublinPark";
    }

    @PostMapping("/addDublinPark")
    public String addDublinPark(@ModelAttribute("dublinPark") DublinPark dublinPark) {
        dublinParkService.saveDublinPark(dublinPark);
        return "redirect:/dublinPark";
    }

    @GetMapping("/updateDublinPark/{id}")
    public String updateDublinPark(@PathVariable(value = "id") long id, Model model) {
        DublinPark dublinPark = dublinParkService.getDublinParkById(id);
        model.addAttribute("dublinPark", dublinPark);
        return "updateDublinPark";

    }

    @GetMapping("/viewDublinPark/{id}")
    public String viewDublinPark(@PathVariable(value = "id") long id, Model model) {
        DublinPark dublinPark = dublinParkService.getDublinParkById(id);
        model.addAttribute("dublinPark", dublinPark);
        return "dublinParkDetails";
    }

    @GetMapping("/deleteDublinPark/{id}")
    public String deleteDublinPark(@PathVariable(value = "id") long id) {
        this.dublinParkService.deleteDublinParkById(id);
        return "redirect:/dublinPark";
    }
}
