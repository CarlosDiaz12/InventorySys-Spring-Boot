package com.cejgroup.inventorysystem.domain.interfaces.Store;

import com.cejgroup.inventorysystem.domain.entities.Store;
import com.cejgroup.inventorysystem.dto.store.CreateOrUpdateStoreDto;

import java.util.List;

public interface IStoreService {
    List<Store> getAll();
    CreateOrUpdateStoreDto getById(long id);
    void create(CreateOrUpdateStoreDto createOrUpdateStoreDto);
    void edit(CreateOrUpdateStoreDto createOrUpdateStoreDto);
}
