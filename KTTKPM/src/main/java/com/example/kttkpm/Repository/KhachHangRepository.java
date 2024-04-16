package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.dto.KhachHangDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    KhachHang findKhachHangByTaiKhoanId(int id) ;

    KhachHang findKhachHangBySdt(String sdt) ;

    Boolean existsBySdt(String sdt);

    Optional<KhachHang> findKHBySdt(String sdt) ;
}
