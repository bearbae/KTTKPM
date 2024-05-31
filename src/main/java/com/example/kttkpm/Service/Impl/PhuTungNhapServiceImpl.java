package com.example.kttkpm.Service.Impl;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.PhuTung;
import com.example.kttkpm.Model.PhuTungNhap;
import com.example.kttkpm.Repository.PhuTungNhapRepository;

import com.example.kttkpm.Service.HoaDonNHapService;
import com.example.kttkpm.Service.PhuTungNhapService;
import com.example.kttkpm.Service.PhuTungService;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import com.example.kttkpm.dto.PhuTungNhapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhuTungNhapServiceImpl implements PhuTungNhapService {

    @Autowired
    private PhuTungService phuTungService;
    @Autowired
    private HoaDonNHapService hoaDonNHapService;
    @Autowired
    private PhuTungNhapRepository phuTungNhapRepository;

    @Override
    public PhuTungNhap nhapPhuTung(PhuTungNhapDTO phuTungDTO) {
        PhuTungNhap x = new PhuTungNhap();
        x.setGia(phuTungDTO.getGia());
        x.setSoluong(phuTungDTO.getSoluong());
        x.setPhuTung(phuTungService.getPhuTungById(phuTungDTO.getIdpt()));
        x.setHoaDonNhap(hoaDonNHapService.findHDNById(phuTungDTO.getIdhdn()));
        x = phuTungNhapRepository.save(x);
        PhuTungNhap phuTungNhap = new PhuTungNhap();

        if (x != null) {
            phuTungNhap.setId(x.getId());
            phuTungNhap.setGia(x.getGia());
            phuTungNhap.setSoluong(x.getSoluong());
            phuTungNhap.setPhuTung(x.getPhuTung());
            phuTungNhap.setHoaDonNhap(x.getHoaDonNhap());
            return phuTungNhap;
        } else
            return null;
    }

    @Override
    public List<PhuTungNhap> getPtByIdHd(long idhdn) {
        return phuTungNhapRepository.findPhuTungNhapsByHoaDonNhapId(idhdn);
    }

    @Override
    public boolean deletePtnById(long id) {
        if (phuTungNhapRepository.existsById(id)) {
            phuTungNhapRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
