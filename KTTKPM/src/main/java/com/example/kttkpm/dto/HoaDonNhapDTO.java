package com.example.kttkpm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonNhapDTO {
    private long id ;
    private long id_tk ;
    private long id_ncc ;
    private float thanhtien ;
    private String ngay ;
}
