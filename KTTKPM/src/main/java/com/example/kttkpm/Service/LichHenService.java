package com.example.kttkpm.Service;

import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Model.LichHen;
import com.example.kttkpm.dto.LichHenDTO;

import java.util.List;

public interface LichHenService  {

     String datlich(LichHenDTO lichHenDTO) ;
     // lay tat ca lichhen tu khach hang

     List<LichHen> getAllLichHenByKh(String sdt) ;
}
