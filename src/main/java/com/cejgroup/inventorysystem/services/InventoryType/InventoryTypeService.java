package com.cejgroup.inventorysystem.services.InventoryType;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeRepository;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InventoryTypeService implements IInventoryTypeService {
    @Autowired
    private IInventoryTypeRepository inventoryTypeRepository;
    @Override
    public Collection<InventoryType> getAll() {
        return inventoryTypeRepository.findAll();
    }
}
