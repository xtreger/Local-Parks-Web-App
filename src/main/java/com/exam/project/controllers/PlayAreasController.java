package com.exam.project.controllers;

import com.exam.project.models.PlayAreas;
import com.exam.project.services.PlayAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayAreasController {

    @Autowired
    private PlayAreasService playAreasService;

    @GetMapping("/playAreas")
    public String viewPlayAreas(Model model) {
        playAreasService.addAllPlayAreas();
        model.addAttribute("playAreasList", playAreasService.getAllPlayAreas());
        return "playAreas";
    }

    @GetMapping("/showNewPlayAreaForm")
    public String showNewPlayAreaForm(Model model) {
        PlayAreas playAreas = new PlayAreas();
        model.addAttribute("playAreas", playAreas);
        return "addPlayArea";
    }

    @PostMapping("/addPlayAreas")
    public String addPlayAreas(@ModelAttribute("playAreas") PlayAreas playAreas) {
        playAreasService.savePlayAreas(playAreas);
        return "redirect:/playAreas";
    }

    @GetMapping("/updatePlayAreas/{id}")
    public String updatePlayAreas(@PathVariable(value = "id") long id, Model model) {
        PlayAreas playAreas = playAreasService.getPlayAreasById(id);
        model.addAttribute("playAreas", playAreas);
        return "updatePlayArea";

    }

    @GetMapping("/viewPlayAreas/{id}")
    public String viewPlayAreas(@PathVariable(value = "id") long id, Model model) {
        PlayAreas playAreas = playAreasService.getPlayAreasById(id);
        model.addAttribute("playAreas", playAreas);
        return "playAreasDetails";
    }

    @GetMapping("/deletePlayAreas/{id}")
    public String deletePlayAreas(@PathVariable(value = "id") long id) {
        this.playAreasService.deletePlayAreasById(id);
        return "redirect:/playAreas";
    }

}
