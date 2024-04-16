package com.example.kttkpm.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="ten")
    private String hoten ;

    @Column(name="diachi")
    private String dchi ;

    @Column(name="sdt")
    private String sdt ;

    @OneToOne
    @JoinColumn(name = "tk_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;


}
