package com.example.demo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AppMVC {
    public static void main(String[] args) {


        ConfigurableApplicationContext run = SpringApplication.run(AppMVC.class, args);

        UserService userService = run.getBean(UserService.class);
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }
}
