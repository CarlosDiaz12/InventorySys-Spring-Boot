package com.cejgroup.inventorysystem.domain.interfaces.User;

import com.cejgroup.inventorysystem.domain.entities.User;
import com.cejgroup.inventorysystem.dto.RegisterUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    public User register(RegisterUserDto dto);
}
