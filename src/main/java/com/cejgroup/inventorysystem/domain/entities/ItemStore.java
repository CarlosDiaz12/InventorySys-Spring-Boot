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
}
