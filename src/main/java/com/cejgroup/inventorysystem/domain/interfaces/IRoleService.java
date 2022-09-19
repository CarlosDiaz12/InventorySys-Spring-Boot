package com.cejgroup.inventorysystem.domain.interfaces;

import com.cejgroup.inventorysystem.domain.entities.Role;

public interface IRoleService {
    public Role getRoleByName(String roleName) throws Exception;
}
