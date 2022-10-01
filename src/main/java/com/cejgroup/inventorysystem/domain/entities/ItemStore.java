package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;

@Table(name = "ItemStore")
@Entity
@IdClass(ItemStoreId.class)
public class ItemStore {
    @Id
    private Long itemId;

    @Id
    private Long storeId;
    @Id
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "itemId", referencedColumnName = "id",insertable = false, updatable = false)
    private Item item;

    @Id
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "storeId", referencedColumnName = "id",insertable = false, updatable = false)
    private Store store;

    @NotNull
    private int quantity;

    public ItemStore() {
    }

    public ItemStore(Long itemId, Long storeId) {
        this.itemId = itemId;
        this.storeId = storeId;
    }

    public ItemStore(Long itemId, Long storeId, int quantity) {
        this.itemId = itemId;
        this.storeId = storeId;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
