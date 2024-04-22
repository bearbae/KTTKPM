package com.example.kttkpm.Repository;

import com.example.kttkpm.Model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {

    Optional<TaiKhoan> findByUsername(String username) ;
    Boolean existsByUsername(String username);

    TaiKhoan getTaiKhoanById(long id) ;
}
