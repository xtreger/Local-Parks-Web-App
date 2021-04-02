package com.exam.project.services;

import com.exam.project.dto.UserRegisterDTO;
import com.exam.project.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    User save(UserRegisterDTO registerDTO);
}
