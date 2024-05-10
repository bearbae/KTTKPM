package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.NhanVienSuaChua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NhanVienSuaChuaRespository extends JpaRepository<NhanVienSuaChua, Long> {
    List<NhanVienSuaChua> findNhanVienSuaChuasByNgaylamAndGiolam(String ngay, String gio) ;
}
