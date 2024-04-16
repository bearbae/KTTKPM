package com.example.kttkpm.Controllers;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DangKyController {

    @GetMapping("/dangky")
    public String dangky(){
        return "dangky" ;
    }
}

