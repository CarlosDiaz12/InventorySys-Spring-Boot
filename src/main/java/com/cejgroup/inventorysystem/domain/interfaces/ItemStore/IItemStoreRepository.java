package com.cejgroup.inventorysystem.domain.interfaces.ItemStore;

import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.entities.ItemStore;
import com.cejgroup.inventorysystem.domain.entities.ItemStoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IItemStoreRepository extends JpaRepository<ItemStore, ItemStoreId> {
    Collection<ItemStore> findByItem(Item item);
    Collection<ItemStore> findByItemNotIn(List<Item> items);
}
