package com.example.oauth2.controller;

import com.example.oauth2.entity.User;
import com.example.oauth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal) {
        User RegisterUser = new User();
        RegisterUser.setBio(principal.getAttribute("bio"));
        RegisterUser.setEmail(principal.getAttribute("email"));
        RegisterUser.setAvatar_url(principal.getAttribute("avatar_url"));
        RegisterUser.setGiven_name(principal.getAttribute("given_name"));
        RegisterUser.setLogin(principal.getAttribute("login"));
        RegisterUser.setName(principal.getAttribute("name"));
        RegisterUser.setPicture(principal.getAttribute("picture"));
        RegisterUser.setType(principal.getAttribute("type"));
        RegisterUser.setUrl(principal.getAttribute("url"));
        userRepository.save(RegisterUser);
        return "index";
    }

    @GetMapping("/lists")
    public String getCategoryList(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "users";

    }
}
