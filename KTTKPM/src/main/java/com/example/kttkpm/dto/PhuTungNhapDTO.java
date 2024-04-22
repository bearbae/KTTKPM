package com.example.kttkpm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhuTungNhapDTO {
    private long idpt ;
    private int idhdn ;
    private String tenpt ;
    private float gia ;
    private int soluong;
}
