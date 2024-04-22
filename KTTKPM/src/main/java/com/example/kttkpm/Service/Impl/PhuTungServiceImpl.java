package com.example.kttkpm.Service.Impl;


import com.example.kttkpm.Model.PhuTung;
import com.example.kttkpm.Repository.PhuTungRepository;
import com.example.kttkpm.Service.PhuTungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhuTungServiceImpl implements PhuTungService {

    @Autowired
    private PhuTungRepository phuTungRepository ;
    @Override
    public List<PhuTung> getAllPhuTungByten(String tenpt) {
        return phuTungRepository.getPhuTungsByTenpt(tenpt);
    }

    @Override
    public String addpt(PhuTung phuTung) {
        PhuTung x = phuTungRepository.save(phuTung) ;
        if(x != null){
            return "Thêm Phụ Tùng Thành Công!" ;
        }
        else return "Thêm Phụ Tùng Thất Bại!" ;
    }

    @Override
    public PhuTung getPhuTungById(long id) {
        return phuTungRepository.findPhuTungById(id);
    }
}
