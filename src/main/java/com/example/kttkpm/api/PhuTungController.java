package com.example.kttkpm.api;


import com.example.kttkpm.Model.PhuTung;
import com.example.kttkpm.Model.PhuTungNhap;
import com.example.kttkpm.Service.PhuTungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pt")
public class PhuTungController {

    @Autowired
    private PhuTungService phuTungService ;


    @GetMapping("/ten/{tenpt}")
    public ResponseEntity<List<PhuTung>> getAllPhuTung(@PathVariable String tenpt){
        List<PhuTung> phuTung = phuTungService.getAllPhuTungByten(tenpt) ;
        return ResponseEntity.ok(phuTung) ;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PhuTung> getPhuTungById(@PathVariable long id){
        PhuTung phuTung = phuTungService.getPhuTungById(id) ;
        return ResponseEntity.ok(phuTung) ;
    }

    @PostMapping("/addpt")
    public ResponseEntity<String> addPhuTung(@RequestBody PhuTung phuTung){
        String response = phuTungService.addpt(phuTung) ;
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;

    }


}
