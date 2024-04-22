package com.example.kttkpm.Service;

import com.example.kttkpm.Model.NhaCungCap;

import java.util.List;

public interface NhaCungCapService {

    List<NhaCungCap> getAllNcc(String ten) ;

    String  addncc(NhaCungCap nhaCungCap) ;

    NhaCungCap getNccById(long id) ;
}
