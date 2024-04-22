package com.example.kttkpm.Repository;


import com.example.kttkpm.Model.NhaCungCap;
import com.example.kttkpm.Model.PhuTung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhuTungRepository extends JpaRepository<PhuTung, Long> {
    List<PhuTung> getPhuTungsByTenpt(String tenpt) ;

    PhuTung findPhuTungById(long id);

//    PhuTung findPhuTungByTenpt(String tenpt) ;


}
