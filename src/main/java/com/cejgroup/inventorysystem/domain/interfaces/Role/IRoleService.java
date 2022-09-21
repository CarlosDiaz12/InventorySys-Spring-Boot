package com.cejgroup.inventorysystem.domain.interfaces.Role;

import com.cejgroup.inventorysystem.domain.entities.Role;

public interface IRoleService {
    public Role getRoleByName(String roleName) throws Exception;
}
