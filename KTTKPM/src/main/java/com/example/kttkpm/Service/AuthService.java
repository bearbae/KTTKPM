package com.example.kttkpm.Service;


import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.dto.DangKyDTO;
import com.example.kttkpm.dto.DangNhapDTO;
import com.example.kttkpm.dto.KhachHangDTO;


public interface AuthService {

    String dangky(DangKyDTO dangKyDTO)  ;
    KhachHangDTO dangnhap(DangNhapDTO dangNhapDTO) ;
}
