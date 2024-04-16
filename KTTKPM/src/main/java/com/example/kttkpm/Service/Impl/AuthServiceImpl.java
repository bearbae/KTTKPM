package com.example.kttkpm.Service.Impl;


import com.example.kttkpm.Model.KhachHang;
import com.example.kttkpm.Model.TaiKhoan;
import com.example.kttkpm.Repository.KhachHangRepository;
import com.example.kttkpm.Repository.TaiKhoanRepository;
import com.example.kttkpm.Service.AuthService;
import com.example.kttkpm.Service.KhachHangService;
import com.example.kttkpm.dto.DangKyDTO;
import com.example.kttkpm.dto.DangNhapDTO;
import com.example.kttkpm.dto.KhachHangDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository ;
    @Autowired
    private KhachHangService khachHangService ;
    @Autowired
    private KhachHangRepository khachHangRepository ;
    @Override
    public String dangky(DangKyDTO dangKyDTO) {
        if(isUsernameAvailable(dangKyDTO.getUsername(),dangKyDTO.getSdt()) ){
            TaiKhoan taiKhoan = taoTK(dangKyDTO.getUsername(),dangKyDTO.getPassword()) ;
            KhachHangDTO khachHangDTO = new KhachHangDTO() ;
            khachHangDTO.setHoten(dangKyDTO.getHoten());
            khachHangDTO.setSdt(dangKyDTO.getSdt());
            khachHangDTO.setDchi(dangKyDTO.getDchi());
            khachHangDTO.setTaiKhoan(taiKhoan);
            System.out.println(khachHangService.taoKhachHang(khachHangDTO));
            return "Đăng Ký Thành Công" ;
        }
        else
        return "Tên Tài Khoản Hoặc Số Điện Thoại Đã Được Sử Dụng";
    }

    private boolean isUsernameAvailable(String username,String sdt) {
        // Kiểm tra xem username or sdt có tồn tại hay không
        return !taiKhoanRepository.existsByUsername(username) && !khachHangRepository.existsBySdt(sdt) ;
    }

    public TaiKhoan taoTK(String username, String password){
        TaiKhoan taiKhoan = new TaiKhoan() ;
        taiKhoan.setUsername(username);
        taiKhoan.setPassword(password);
        taiKhoanRepository.save(taiKhoan) ;
        return taiKhoan ;
    }
    // dang nhap
    @Override
    public KhachHangDTO dangnhap(DangNhapDTO dangNhapDTO) {
        Optional<KhachHangDTO> ktra = ktraUser(dangNhapDTO.getUsername(),dangNhapDTO.getPassword()) ;
        return ktra.orElse(null) ;
    }

    // kiem tra tai khoan co trong db
    private Optional<KhachHangDTO> ktraUser(String username, String password){
        // lay tai khoan tu db theo usename
        Optional<TaiKhoan> tk = taiKhoanRepository.findByUsername(username) ;
        if(tk.isPresent()){
            String mk = tk.get().getPassword() ;
            if(password.equals(mk)){
                // tra ve khach hang
                return Optional.of(khachHangService.getKhachHangByTaiKhoanId(tk.get().getId())) ;
            }
        }
        return Optional.empty() ;
    }


}
