package com.cejgroup.inventorysystem.domain.interfaces.Item;

import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    List<Item> getAll();
    void add(CreateEditItemDto dto) throws Exception;
    void edit(CreateEditItemDto dto) throws Exception;
    Item getById(Long id);
    CreateEditItemDto mapEntityToDto(Item item);
}
