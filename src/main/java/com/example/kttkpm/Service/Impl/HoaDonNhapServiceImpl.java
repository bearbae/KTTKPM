package com.example.kttkpm.Service.Impl;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.NhaCungCap;
import com.example.kttkpm.Model.TaiKhoan;
import com.example.kttkpm.Repository.HoaDonNhapRepository;
import com.example.kttkpm.Service.AuthService;
import com.example.kttkpm.Service.HoaDonNHapService;
import com.example.kttkpm.Service.NhaCungCapService;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import com.example.kttkpm.mappers.HoaDonNhapMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonNhapServiceImpl implements HoaDonNHapService {

    private HoaDonNhapMapper hoaDonNhapMapper ;
    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository ;
    @Autowired
    private AuthService authService ;
    @Autowired
    private NhaCungCapService nhaCungCapService ;
    @Override
    public HoaDonNhapDTO taoHoaDon(HoaDonNhapDTO hoaDonNhapDTO) {
        HoaDonNhap hoaDonNhap = new HoaDonNhap() ;
        NhaCungCap x = nhaCungCapService.getNccById(hoaDonNhapDTO.getId_ncc()) ;
        TaiKhoan y = authService.getTaiKhoanById(hoaDonNhapDTO.getId_tk()) ;
        hoaDonNhap.setNhaCungCap(x);
        hoaDonNhap.setTaiKhoan(y);
        hoaDonNhap = hoaDonNhapRepository.save(hoaDonNhap)  ;
//        if(hoaDonNhap != null) {
//            return "oke" ;
//        }
//        else return "Not ok" ;
        HoaDonNhapDTO rs = new HoaDonNhapDTO() ;
        if(hoaDonNhap != null){
            rs.setId(hoaDonNhap.getId());
            rs.setId_tk(hoaDonNhap.getTaiKhoan().getId());
            return  rs ;
        }
        else{
            return null ;
        }
    }

    @Override
    public List<HoaDonNhap> findListHDNById_tk(long id) {
        List<HoaDonNhap> y = hoaDonNhapRepository.findHoaDonNhapsByTaiKhoan_Id(id);
        return y;
    }

    @Override
    public HoaDonNhap findHDNById(long id) {
        HoaDonNhap x = hoaDonNhapRepository.getHoaDonNhapById(id) ;
        return x ;
    }

    @Override
    public HoaDonNhap getHDNId_Tk(long id_tk) {
        HoaDonNhap x = hoaDonNhapRepository.findHoaDonNhapByTaiKhoan_Id(id_tk) ;
        return x;
    }

    @Override
    public String update(HoaDonNhapDTO hoaDonNhapDTO, long idhdn) {
        Optional<HoaDonNhap> optionalHoaDonNhap = hoaDonNhapRepository.findHoaDonNhapById(idhdn);
        if(optionalHoaDonNhap.isPresent()){
            HoaDonNhap ud = optionalHoaDonNhap.get() ;
            ud.setNgay(hoaDonNhapDTO.getNgay());
            ud.setThanhtien(hoaDonNhapDTO.getThanhtien());
            hoaDonNhapRepository.save(ud) ;
                return "update thanh cong" ;
            }
            else {
                return "update khong thanh cong" ;
            }
    }

//    @Override
//    public List<HoaDonNhap> getList(int id_tk) {
//        return hoaDonNhapRepository.findHoaDonNhapsByTaiKhoan_Id(id_tk);
//    }
}
