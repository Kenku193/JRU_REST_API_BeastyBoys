package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController // ГЛУБОКО ЗАКОНСПЕРИРОВАННЫЙ СЕРВЛЕТ
@RequestMapping("/rest/v1/user/*")
@RequiredArgsConstructor
public class RESTController {

    private final UserService userService;

    // doGet
    @GetMapping("/{id}") // GET -> localhost:8080/rest/v1/user/1
    public ResponseEntity<User> giveMeJson(@PathVariable Long id){
        // МНЕ НУЖНО ПОЙТИ В БД И ВЗЯТЬ ЮЗЕРА С id = {id}
        User user = userService.findById(id).orElseThrow();
       // < --- >
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //doPost
    @PostMapping("/add") // POST -> localhost:8080/rest/v1/user/add
    public void addNewUser(@RequestBody User newUser){ // JSON -> Java Entity ready
        if(Objects.nonNull(newUser)){
            userService.save(newUser);
        }
    }

}
