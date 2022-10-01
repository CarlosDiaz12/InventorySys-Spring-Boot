package com.cejgroup.inventorysystem.domain.entities;

import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

public class ItemStoreId implements Serializable {
    public ItemStoreId() {
    }

    public ItemStoreId(Long itemId, Long storeId) {
        this.itemId = itemId;
        this.storeId = storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, storeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStoreId itemStoreId = (ItemStoreId) o;
        return itemId.equals(itemStoreId.itemId) &&
                storeId.equals(itemStoreId.storeId);
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    private Long itemId;
    private Long storeId;
}
