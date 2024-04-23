package com.example.kttkpm.api;


import com.example.kttkpm.Service.AuthService;
import com.example.kttkpm.dto.DangKyDTO;
import com.example.kttkpm.dto.DangNhapDTO;
import com.example.kttkpm.dto.KhachHangDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService ;
    @PostMapping("/dangky")
    public ResponseEntity<String> dangky(@RequestBody DangKyDTO dangKyDTO  ) {
        String response = authService.dangky(dangKyDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @PostMapping("/dangnhap")
    public ResponseEntity<KhachHangDTO> dangnhap(@RequestBody DangNhapDTO dangNhapDTO){
        KhachHangDTO response = authService.dangnhap(dangNhapDTO) ;
        if (response == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
