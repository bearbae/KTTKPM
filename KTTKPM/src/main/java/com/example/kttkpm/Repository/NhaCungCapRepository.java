package com.example.kttkpm.Repository;


import com.example.kttkpm.Model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {
    List<NhaCungCap> getNhaCungCapsByTen(String ten) ;

    NhaCungCap findNhaCungCapById(long id) ;
}
