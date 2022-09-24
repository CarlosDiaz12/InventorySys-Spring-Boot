package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;

@Table(name = "ItemStore")
@Entity
@IdClass(ItemStoreId.class)
public class ItemStore {

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @NotNull
    private int quantity;

    public ItemStore() {
    }

    public ItemStore(Item item, Store store, int quantity) {
        this.item = item;
        this.store = store;
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
