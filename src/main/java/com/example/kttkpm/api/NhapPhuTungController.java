package com.example.kttkpm.api;


import com.example.kttkpm.Model.PhuTung;
import com.example.kttkpm.Model.PhuTungNhap;
import com.example.kttkpm.Service.PhuTungNhapService;
import com.example.kttkpm.dto.PhuTungNhapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/npt")
public class NhapPhuTungController {
    @Autowired
    private PhuTungNhapService phuTungNhapService ;

    @PostMapping("/nhap")
    public ResponseEntity<PhuTungNhap> nhapPhuTung(@RequestBody PhuTungNhapDTO phuTungNhapDTO){
        PhuTungNhap phuTungNhap = phuTungNhapService.nhapPhuTung(phuTungNhapDTO) ;
        return  ResponseEntity.ok(phuTungNhap);
    }

    @GetMapping("/idhdn/{idhdn}")
    public ResponseEntity<List<PhuTungNhap>> getAllPhuTung(@PathVariable long idhdn){
        List<PhuTungNhap> phuTungNhaps = phuTungNhapService.getPtByIdHd(idhdn) ;
        return ResponseEntity.ok(phuTungNhaps) ;
    }
    @DeleteMapping("/delete/{id}")
    public  boolean deletePhuTungNhap(@PathVariable long id){
        boolean rs = phuTungNhapService.deletePtnById(id) ;
        return rs ;
    }
}
