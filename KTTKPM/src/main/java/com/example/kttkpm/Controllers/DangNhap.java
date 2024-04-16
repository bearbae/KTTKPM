package com.example.kttkpm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DangNhap {
    @GetMapping("/dangnhap")
    public String dangnhap(){
        return "dangnhap" ;
    }
}
