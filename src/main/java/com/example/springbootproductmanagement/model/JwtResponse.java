package com.example.springbootproductmanagement.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//Tạo class JwtResponse để cấu hình lại thông điệp trả về sau khi đăng nhập thành công.
@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> roles;


    public JwtResponse(String accessToken, Long id, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }
}
