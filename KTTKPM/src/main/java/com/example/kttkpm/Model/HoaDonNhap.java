package com.example.kttkpm.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hoadonnhap")
public class HoaDonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;
    private String ngay ;
    private float thanhtien ;

    @ManyToOne()
    @JoinColumn(name = "id_ncc", referencedColumnName = "id")
    private NhaCungCap nhaCungCap ;
    @ManyToOne()
    @JoinColumn(name = "id_tk", referencedColumnName = "id")
    private TaiKhoan taiKhoan ;


}
