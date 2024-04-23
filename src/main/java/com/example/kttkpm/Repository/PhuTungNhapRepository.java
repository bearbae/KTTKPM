package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.PhuTungNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhuTungNhapRepository extends JpaRepository<PhuTungNhap, Long> {
    List<PhuTungNhap> findPhuTungNhapsByHoaDonNhapId(long id) ;
}
