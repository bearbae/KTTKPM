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
@Table(name="phutungnhap")
public class PhuTungNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int soluong ;
    private float gia ;
    @ManyToOne()
    @JoinColumn(name ="pt_id", referencedColumnName = "id")
    private PhuTung phuTung ;
    @ManyToOne()
    @JoinColumn(name = "hd_id", referencedColumnName = "id" )
    private HoaDonNhap hoaDonNhap ;
}
