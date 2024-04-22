package com.example.kttkpm.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phutung")
public class PhuTung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id  ;
    private String tenpt ;
    private String mota ;

}
