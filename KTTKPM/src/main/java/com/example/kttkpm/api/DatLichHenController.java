package com.example.kttkpm.api;

import com.example.kttkpm.Model.LichHen;
import com.example.kttkpm.Service.LichHenService;
import com.example.kttkpm.dto.LichHenDTO;
import com.example.kttkpm.dto.DangKyDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DatLichHenController {

    @Autowired
    private LichHenService lichHenService ;

    @PostMapping("/lichhen")
    public ResponseEntity<String> datlich(@RequestBody LichHenDTO lichHenDTO) {
//        System.out.println(lichHenDTO);
        String response = lichHenService.datlich(lichHenDTO) ;
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // in lich hen
    @GetMapping("/list/{sdt}")
    public ResponseEntity<List<LichHen>> getAllLichHen(@PathVariable String sdt) {
        // Gọi service để lấy tất cả lichhen cho kh_id
        List<LichHen> lichHens = lichHenService.getAllLichHenByKh(sdt) ;
        return ResponseEntity.ok(lichHens);
    }
}
