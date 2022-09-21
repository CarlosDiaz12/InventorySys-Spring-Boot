package com.cejgroup.inventorysystem.services.Role;

import com.cejgroup.inventorysystem.domain.entities.Role;
import com.cejgroup.inventorysystem.domain.interfaces.Role.IRoleRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    private IRoleRepository roleRepository;
    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String roleName) throws Exception{
        Role role = roleRepository.findByName(roleName);

        if(role == null)
            throw new Exception("Role not found");
        return role;
    }
}
