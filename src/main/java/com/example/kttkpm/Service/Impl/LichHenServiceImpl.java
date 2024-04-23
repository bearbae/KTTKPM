package com.example.kttkpm.Service.Impl;


import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Model.LichHen;
import com.example.kttkpm.Repository.KhachHangRepository;
import com.example.kttkpm.Repository.LichHenRepository;
import com.example.kttkpm.Service.KhachHangService;
import com.example.kttkpm.Service.LichHenService;
import com.example.kttkpm.dto.LichHenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LichHenServiceImpl implements LichHenService {

    @Autowired
    private LichHenRepository lichHenRepository ;
    @Autowired
    private KhachHangRepository khachHangRepository ;
    @Autowired
    private KhachHangService khachHangService  ;
    @Override
    public String datlich(LichHenDTO lichHenDTO) {
        LichHen lichHen = new LichHen() ;
        lichHen.setNgay(lichHenDTO.getNgay());
        lichHen.setGio(lichHenDTO.getGio());
        lichHen.setLoinhan(lichHenDTO.getLoinhan());
        KhachHang x = khachHangRepository.findKhachHangBySdt(lichHenDTO.getSdt()) ;
        lichHen.setKhachHang(x);
        lichHen = taolichhen(lichHen);
        System.out.println(lichHen.getNgay());
        if (lichHen != null) {
            return "Đặt lịch hẹn thành công";
        } else {
            return "Đặt lịch hẹn không thành công";
        }

    }
    private LichHen taolichhen(LichHen lichHen){
        lichHenRepository.save(lichHen)  ;
        return lichHen ;
    }

//    //lay tat ca lichhen tu kh_id
//    public List<LichHen> getAllLichHenByKhId(Long KhachHangId){
//        return lichHenRepository.findLichHensByKhId(KhachHangId);
//    }
//
//    // lay kh tu sdt
    @Override
    public List<LichHen> getAllLichHenByKh(String sdt) {
        KhachHang m = khachHangRepository.findKhachHangBySdt(sdt) ;
        System.out.println(m);
        return lichHenRepository.findLichHensByKhachHang_Id(m.getId());
    }

}
