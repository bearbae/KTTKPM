package com.example.kttkpm.Service;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.TaiKhoan;
import com.example.kttkpm.dto.HoaDonNhapDTO;

import java.util.List;

public interface HoaDonNHapService {
    String taoHoaDon(HoaDonNhapDTO hoaDonNhapDTO)  ;



    HoaDonNhap getHDNId_Tk(long id_tk) ;

    String update(HoaDonNhapDTO hoaDonNhapDTO, long idhdn) ;
//    List<HoaDonNhap> getList(int id_tk) ;
}
