package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ГЛУБОКО ЗАКОНСПЕРИРОВАННЫЙ СЕРВЛЕТ
@RequestMapping("/api/v1/user/*")
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    // doGet
    @GetMapping("/{id}") // GET -> localhost:8080/api/v1/user/1
    public String giveMeJson(Model model, @PathVariable Long id){
        // МНЕ НУЖНО ПОЙТИ В БД И ВЗЯТЬ ЮЗЕРА С id = {id}
        User user = userService.findById(id).orElseThrow();
        model.addAttribute("UserId", user.getId());
        model.addAttribute("UserLogin", user.getLogin());
        model.addAttribute("UserPassword", user.getPassword());
        return "jsonMapper";
    }

}
