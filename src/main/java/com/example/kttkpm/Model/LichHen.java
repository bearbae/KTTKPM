package com.example.kttkpm.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lichhen")
public class LichHen {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "ngay")
        private String ngay;

        @Column(name = "gio")
        private String gio;

        @Column(name="loinhan")
        private String loinhan ;
        @ManyToOne
        @JoinColumn(name = "kh_id", referencedColumnName = "id")
        private KhachHang khachHang;



}
