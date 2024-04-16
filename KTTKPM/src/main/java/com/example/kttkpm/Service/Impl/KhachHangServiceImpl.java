package com.example.kttkpm.Service.Impl;


import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Repository.KhachHangRepository;
import com.example.kttkpm.Service.KhachHangService;
import com.example.kttkpm.dto.KhachHangDTO;
import com.example.kttkpm.mappers.KhachHangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository ;
    @Autowired
    private KhachHangMapper khachHangMapper ;
    @Override
    public String taoKhachHang(KhachHangDTO khachHangDTO) {
        KhachHang x = khachHangMapper.convertToEntity(khachHangDTO) ;
        khachHangRepository.save(x) ;
        return "Tao Khach Hang Thanh Cong";
    }

    @Override
    public KhachHangDTO getKhachHangByTaiKhoanId(int id) {
        return khachHangMapper.convertToDTO(khachHangRepository.findKhachHangByTaiKhoanId(id)) ;
    }

    // lay khachhang tu sdt
    @Override
    public KhachHangDTO getKhachHangBySdt(String sdt) {
        return khachHangMapper.convertToDTO(khachHangRepository.findKhachHangBySdt(sdt));
    }

    @Override
    public KhachHang getKhBySdt(String sdt) {
        return khachHangRepository.findKhachHangBySdt(sdt);
    }


}
