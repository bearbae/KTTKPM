package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.HoaDonNhap;
import com.example.kttkpm.Model.TaiKhoan;
import com.example.kttkpm.dto.HoaDonNhapDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap, Long> {

    HoaDonNhap findHoaDonNhapByTaiKhoan_Id(long id_id) ;

    HoaDonNhap getHoaDonNhapById(long id) ;

    List<HoaDonNhap> findHoaDonNhapsByTaiKhoan_Id(long id) ;

    Optional<HoaDonNhap> findHoaDonNhapById(long id) ;


}
