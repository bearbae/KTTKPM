package com.example.kttkpm.Service;


import com.example.kttkpm.Model.PhuTung;

import com.example.kttkpm.Model.PhuTungNhap;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import com.example.kttkpm.dto.PhuTungNhapDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PhuTungNhapService {
    String nhapPhuTung(PhuTungNhapDTO PhuTungDTO) ;

    List<PhuTungNhap>  getPtByIdHd(long idhdn ) ;
}
