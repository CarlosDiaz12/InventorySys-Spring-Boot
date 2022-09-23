package com.cejgroup.inventorysystem.domain.interfaces.InventoryType;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.dto.CreateEditInventoryTypeDto;
import javassist.NotFoundException;

import java.util.Collection;
import java.util.List;

public interface IInventoryTypeService {
    List<InventoryType> getAll();
    void add(CreateEditInventoryTypeDto dto) throws Exception;
    void edit(CreateEditInventoryTypeDto dto) throws Exception;
    InventoryType getById(Long id) throws NotFoundException;
    void deleteById(Long id) throws NotFoundException;
    CreateEditInventoryTypeDto mapEntityToDto(InventoryType inventoryType);
}
