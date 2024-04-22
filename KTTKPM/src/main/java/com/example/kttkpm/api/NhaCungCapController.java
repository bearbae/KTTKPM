package com.example.kttkpm.api;


import com.example.kttkpm.Model.NhaCungCap;
import com.example.kttkpm.Service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService nhaCungCapService ;


    @GetMapping("/ncc/ten/{ten}")
    public ResponseEntity<List<NhaCungCap>> getAllNcc(@PathVariable String ten){
        List<NhaCungCap> ncc = nhaCungCapService.getAllNcc(ten) ;
        return ResponseEntity.ok(ncc) ;
    }

    @PostMapping("/addncc")
    public ResponseEntity<String> addNcc(@RequestBody NhaCungCap nhaCungCap){
        String response = nhaCungCapService.addncc(nhaCungCap) ;
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }

    @GetMapping("/ncc/id/{id}")
    public ResponseEntity<NhaCungCap> getNccById(@PathVariable Long id){
        NhaCungCap x = nhaCungCapService.getNccById(id) ;
        return  ResponseEntity.ok(x) ;
    }
}
