package com.cejgroup.inventorysystem.services;

import antlr.actions.python.CodeLexer;
import com.cejgroup.inventorysystem.domain.entities.Role;
import com.cejgroup.inventorysystem.domain.entities.User;
import com.cejgroup.inventorysystem.domain.interfaces.IRoleRepository;
import com.cejgroup.inventorysystem.domain.interfaces.IUserRepository;
import com.cejgroup.inventorysystem.domain.interfaces.IUserService;
import com.cejgroup.inventorysystem.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(RegisterUserDto dto) {
        Role basicRole;
        try {
            basicRole = roleRepository.findByName("USER");
        } catch (Exception e) {
            basicRole = new Role("USER");
        }
        User newUser = new User(
                dto.getName(),
                dto.getUserName(),
                dto.getEmail(),
                bCryptPasswordEncoder.encode(dto.getPassword()),
                Arrays.asList(basicRole));
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Username does not exists.");
        }
        System.out.println("User Service:" + username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
