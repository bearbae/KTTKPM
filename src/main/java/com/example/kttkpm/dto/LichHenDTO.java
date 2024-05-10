package com.example.kttkpm.dto;

import com.example.kttkpm.Model.KhachHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichHenDTO {

    private Long id  ;
    private String ngay ;
    private String gio ;
    private String loinhan ;
    private String sdt ;
    private KhachHang khachHang ;

}
