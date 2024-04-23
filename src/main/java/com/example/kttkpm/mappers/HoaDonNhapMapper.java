package com.example.kttkpm.mappers;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import com.example.kttkpm.dto.KhachHangDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HoaDonNhapMapper {
    private final ModelMapper modelMapper ;

    public HoaDonNhapMapper() {
        this.modelMapper = new ModelMapper() ;
    }

    public HoaDonNhapDTO convertToDTO(HoaDonNhap hoaDonNhap) {
        return modelMapper.map(hoaDonNhap, HoaDonNhapDTO.class);
    }

    public HoaDonNhap convertToEntity(HoaDonNhapDTO hoaDonNhapDTO) {
        return modelMapper.map(hoaDonNhapDTO, HoaDonNhap.class);
    }
}
