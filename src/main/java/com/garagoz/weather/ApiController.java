package com.garagoz.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/test")
    public String ShowMessage() {
        return "Hello Arslan!";
    }
}
