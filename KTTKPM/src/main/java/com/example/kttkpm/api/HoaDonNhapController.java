package com.example.kttkpm.api;


import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Repository.HoaDonNhapRepository;
import com.example.kttkpm.Service.HoaDonNHapService;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import com.example.kttkpm.dto.PhuTungNhapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hdn")
public class HoaDonNhapController {

    @Autowired
    private HoaDonNHapService hoaDonNHapService ;
    @PostMapping("/taohd")
    public ResponseEntity<String> taoHoaDonNhap(@RequestBody  HoaDonNhapDTO hoaDonNhapDTO){
        String response = hoaDonNHapService.taoHoaDon(hoaDonNhapDTO) ;
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }


    @GetMapping("/{id_tk}")
    public ResponseEntity<HoaDonNhap> getHoaDonNhap(@PathVariable long id_tk){
        HoaDonNhap x  = hoaDonNHapService.getHDNId_Tk(id_tk) ;
        return ResponseEntity.ok(x) ;
    }

    @PutMapping("/update/{idhdn}")
    public ResponseEntity<String> update(@RequestBody HoaDonNhapDTO hoaDonNhapDTO,@PathVariable long idhdn) {
        String response = hoaDonNHapService.update(hoaDonNhapDTO, idhdn)  ;
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }


}
