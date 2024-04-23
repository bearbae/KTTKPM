package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Model.LichHen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichHenRepository extends JpaRepository<LichHen, Long> {
    // lay tat ca lich hen tu id khach hang
    List<LichHen> findLichHensByKhachHang_Id(Long id);
}
