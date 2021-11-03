package com.example.springbootproductmanagement.service.user;

import com.example.springbootproductmanagement.model.User;
import com.example.springbootproductmanagement.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String name);
}
