package com.example.kttkpm.Service;


import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.dto.KhachHangDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface KhachHangService {
    String taoKhachHang(KhachHangDTO khachHangDTO) ;

    KhachHangDTO  getKhachHangByTaiKhoanId(int id) ;

    KhachHangDTO getKhachHangBySdt(String sdt) ;

    // lay kh bang sdt
    KhachHang getKhBySdt(String sdt) ;

}
