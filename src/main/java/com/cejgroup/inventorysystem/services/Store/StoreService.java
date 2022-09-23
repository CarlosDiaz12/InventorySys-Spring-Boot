package com.cejgroup.inventorysystem.services.Store;

import com.cejgroup.inventorysystem.domain.entities.Store;
import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreService;
import com.cejgroup.inventorysystem.dto.store.CreateOrUpdateStoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {

    private IStoreRepository storeRepository;
    @Autowired
    public StoreService(IStoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public CreateOrUpdateStoreDto getById(long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isEmpty()) return null;
        return new CreateOrUpdateStoreDto(
                store.get().getId(),
                store.get().getDescription(),
                store.get().isStatus()
        );
    }

    public void create(CreateOrUpdateStoreDto createOrUpdateStoreDto) {
        Store newStore = new Store(
                createOrUpdateStoreDto.getId(),
                createOrUpdateStoreDto.getDescription(),
                createOrUpdateStoreDto.isStatus()
        );
        storeRepository.save(newStore);
    }

    public void edit(CreateOrUpdateStoreDto createOrUpdateStoreDto) {

        Store store = storeRepository.findById(createOrUpdateStoreDto.getId()).get();
        store.setDescription(createOrUpdateStoreDto.getDescription());
        store.setStatus(createOrUpdateStoreDto.isStatus());

        storeRepository.save(store);
    }

    public void delete(long id) {
        Store store = storeRepository.findById(id).get();
        storeRepository.delete(store);
    }
}
