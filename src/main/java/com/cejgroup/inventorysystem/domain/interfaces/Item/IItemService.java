package com.cejgroup.inventorysystem.domain.interfaces.Item;

import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.entities.Store;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    List<Item> getAll();
    List<Store> getItemStores(Long id);
    List<Store> getNotInItemStores(Long id);
    void add(CreateEditItemDto dto) throws Exception;
    void edit(CreateEditItemDto dto) throws Exception;
    Item getById(Long id) throws NotFoundException;
    void deleteById(Long id) throws NotFoundException;
    CreateEditItemDto mapEntityToDto(Item item);
}
