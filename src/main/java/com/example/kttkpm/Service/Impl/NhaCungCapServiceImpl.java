package com.example.kttkpm.Service.Impl;

import com.example.kttkpm.Model.NhaCungCap;
import com.example.kttkpm.Repository.NhaCungCapRepository;
import com.example.kttkpm.Service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository ;
    @Override
    public List<NhaCungCap> getAllNcc(String ten) {
        return nhaCungCapRepository.getNhaCungCapsByTen(ten);
    }

    @Override
    public String addncc(NhaCungCap nhaCungCap) {
       NhaCungCap x =  nhaCungCapRepository.save(nhaCungCap) ;
       if(x == null){
           return "khong" ;
       }
       else
        return "Them nha cung cap thanh cong!";
    }

    @Override
    public NhaCungCap getNccById(long id) {
        return nhaCungCapRepository.findNhaCungCapById(id) ;
    }

}
