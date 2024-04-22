package com.example.kttkpm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // dang ky dang nhap
    @GetMapping("/dangnhap")
    public String dangnhap(){
        return "dangnhap" ;
    }

    @GetMapping("/dangky")
    public String dangky(){
        return "dangky" ;
    }

    //dat lich hen
    @GetMapping("/lichhen")
    public String datlich() {
        return "lichhen" ;
    }

    // nha cung cap
    @GetMapping("/ncc")
    public String ncc(){
        return "nhacungcap" ;
    }

    @GetMapping("/addncc")
    public String addncc(){
        return "addncc" ;
    }


    // hoa don nhap
    @GetMapping("/hoadonnhap")
    public String hoadonnhap(){
        return "hoadonnhap" ;
    }

    // home

    @GetMapping("/home")
    public String home(){
        return "home" ;
    }

    //phu tung
    @GetMapping("/phutung")
    public String Phutung(){
        return "/phutung" ;
    }

    @GetMapping("/addpt")
    public String addpt(){
        return "/addpt" ;
    }
}
