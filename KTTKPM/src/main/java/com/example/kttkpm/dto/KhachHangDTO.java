package com.example.kttkpm.dto;

import com.example.kttkpm.Model.TaiKhoan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangDTO {

    private String hoten ;
    private String sdt ;
    private String dchi ;
    private TaiKhoan taiKhoan ;
}
