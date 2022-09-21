package com.cejgroup.inventorysystem.domain.entities;

import java.io.Serializable;
import java.util.Objects;

public class ItemStoreId implements Serializable {
    public ItemStoreId() {
    }

    public ItemStoreId(Item item, Store store) {
        this.item = item;
        this.store = store;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, store);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStoreId itemStoreId = (ItemStoreId) o;
        return item.getId().equals(itemStoreId.item.getId()) &&
                store.getId().equals(itemStoreId.store.getId());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private Item item;

    private Store store;
}
