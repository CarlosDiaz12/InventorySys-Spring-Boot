package com.cejgroup.inventorysystem.domain.interfaces.ItemStore;

import com.cejgroup.inventorysystem.domain.entities.ItemStore;
import com.cejgroup.inventorysystem.domain.entities.ItemStoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemStoreRepository extends JpaRepository<ItemStore, ItemStoreId> {
}
