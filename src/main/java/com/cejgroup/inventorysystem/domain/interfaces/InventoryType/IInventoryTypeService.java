package com.cejgroup.inventorysystem.domain.interfaces.InventoryType;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;

import java.util.Collection;

public interface IInventoryTypeService {
    Collection<InventoryType> getAll();
}
