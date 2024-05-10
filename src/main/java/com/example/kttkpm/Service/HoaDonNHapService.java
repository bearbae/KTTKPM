package com.example.kttkpm.Service;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.TaiKhoan;
import com.example.kttkpm.dto.HoaDonNhapDTO;

import java.util.List;

public interface HoaDonNHapService {
    HoaDonNhapDTO taoHoaDon(HoaDonNhapDTO hoaDonNhapDTO)  ;


    List<HoaDonNhap> findListHDNById_tk(long id) ;

    HoaDonNhap findHDNById(long id) ;
    HoaDonNhap getHDNId_Tk(long id_tk) ;

//    HoaDonNhap getHDNId(long id) ;

    String update(HoaDonNhapDTO hoaDonNhapDTO, long idhdn) ;
//    List<HoaDonNhap> getList(int id_tk) ;
}
