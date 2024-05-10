package com.example.kttkpm.Service.Impl;

import com.example.kttkpm.Model.NhanVienSuaChua;
import com.example.kttkpm.Repository.NhanVienSuaChuaRespository;
import com.example.kttkpm.Service.NhanVienSuaChuaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NhanVienSuaChuaServiceImpl implements NhanVienSuaChuaService {

    @Autowired
    private NhanVienSuaChuaRespository nhanVienSuaChuaRespository ;
    @Override
    public boolean checkDateAndTime(String date, String time) {

        List<NhanVienSuaChua> list = nhanVienSuaChuaRespository.findNhanVienSuaChuasByNgaylamAndGiolam(date,time) ;
       return !list.isEmpty() ;
    }
}
