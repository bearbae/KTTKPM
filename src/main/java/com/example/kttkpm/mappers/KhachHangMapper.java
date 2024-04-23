package com.example.kttkpm.mappers;

import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Model.LichHen;
import com.example.kttkpm.dto.KhachHangDTO;
import com.example.kttkpm.dto.LichHenDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class KhachHangMapper {
    private final ModelMapper modelMapper ;

    public KhachHangMapper() {
        this.modelMapper = new ModelMapper() ;
    }

    public KhachHangDTO convertToDTO(KhachHang khachHang) {
        return modelMapper.map(khachHang, KhachHangDTO.class);
    }

    public KhachHang convertToEntity(KhachHangDTO khachHangDTO) {
        return modelMapper.map(khachHangDTO, KhachHang.class);
    }
}
