package com.example.kttkpm.Service;

import com.example.kttkpm.Model.NhaCungCap;
import com.example.kttkpm.Model.PhuTung;

import java.util.List;

public interface PhuTungService {
    List<PhuTung> getAllPhuTungByten(String tenpt) ;

    String  addpt(PhuTung phuTung) ;

    PhuTung getPhuTungById(long id) ;
}
