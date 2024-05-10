package com.example.kttkpm.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVienSuaChua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="ten")
    private String hoten ;

    @Column(name="diachi")
    private String dchi ;

    @Column(name="sdt")
    private String sdt ;

    @Column(name="tienluong")
    private String tienluong;
    @Column(name="chucvu")
    private String chucvu ;

    @Column(name="ngaylam")
    private String ngaylam ;

    @Column(name="giolam")
    private String giolam ;

    @OneToOne
    @JoinColumn(name = "tk_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;
}
