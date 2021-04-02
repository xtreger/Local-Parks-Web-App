package com.exam.project.controllers;

import com.exam.project.models.DunLaoghairePark;
import com.exam.project.services.DunLaoghaireParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DunLaoghaireParkController {

    @Autowired
    private DunLaoghaireParkService dunLaoghaireParkService;

    @GetMapping("/dunLaoghairePark")
    public String viewDunLaoghairePark(Model model) {
        dunLaoghaireParkService.addAllDunLaoghairePark();
        model.addAttribute("dunLaoghaireParkList", dunLaoghaireParkService.getAllDunLaoghairePark());
        return "dunLaoghairePark";
    }

    @GetMapping("/showNewDunLaoghaireParkForm")
    public String showNewDunLaoghaireParkForm(Model model) {
        DunLaoghairePark dunLaoghairePark = new DunLaoghairePark();
        model.addAttribute("dunLaoghairePark", dunLaoghairePark);
        return "addDunLaoghairePark";
    }

    @PostMapping("/addDunLaoghairePark")
    public String addDunLaoghairePark(@ModelAttribute("dunLaoghairePark") DunLaoghairePark dunLaoghairePark) {
        dunLaoghaireParkService.saveDunLaoghairePark(dunLaoghairePark);
        return "redirect:/dunLaoghairePark";
    }

    @GetMapping("/updateDunLaoghairePark/{id}")
    public String updateDunLaoghairePark(@PathVariable(value = "id") long id, Model model) {
        DunLaoghairePark dunLaoghairePark = dunLaoghaireParkService.getDunLaoghaireParkById(id);
        model.addAttribute("dunLaoghairePark", dunLaoghairePark);
        return "updateDunLaoghairePark";

    }

    @GetMapping("/viewDunLaoghairePark/{id}")
    public String viewDunLaoghairePark(@PathVariable(value = "id") long id, Model model) {
        DunLaoghairePark dunLaoghairePark = dunLaoghaireParkService.getDunLaoghaireParkById(id);
        model.addAttribute("dunLaoghairePark", dunLaoghairePark);
        return "dunLaoghaireParkDetails";
    }

    @GetMapping("/deleteDunLaoghairePark/{id}")
    public String deleteDunLaoghairePark(@PathVariable(value = "id") long id) {
        this.dunLaoghaireParkService.deleteDunLaoghaireParkById(id);
        return "redirect:/dunLaoghairePark";
    }
}