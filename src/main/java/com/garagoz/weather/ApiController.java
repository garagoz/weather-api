package com.garagoz.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/hello")
    public String ShowMessage() {
        return "Hello World!";
    }

    @GetMapping("/welcome")
    public String WelcomeMessage() {
        return "Welcome World! ";
    }
}
