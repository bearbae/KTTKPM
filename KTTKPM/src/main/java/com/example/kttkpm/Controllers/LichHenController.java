package com.example.kttkpm.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LichHenController {
    @GetMapping("/lichhen")
    public String datlich() {
        return "lichhen" ;
    }
}
