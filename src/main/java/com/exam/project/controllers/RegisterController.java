package com.exam.project.controllers;

import com.exam.project.dto.UserRegisterDTO;
import com.exam.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegisterDTO registerDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "You have been registered successfully.");
        userService.save(registerDTO);

        return "redirect:/login";
    }

    @GetMapping
    public String registerForm() {
        return "register";
    }

    @ModelAttribute("user")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }
}
