package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table(name = "Items")
@Entity
public class Item {
    public Item(String description, InventoryType inventoryType, Long stock, Double unitPrice, boolean status) {
        this.description = description;
        this.inventoryType = inventoryType;
        this.stock = stock;
        UnitPrice = unitPrice;
        this.status = status;
    }

    public Item(Long id, String description, InventoryType inventoryType, Long stock, Double unitPrice, boolean status) {
        this.id = id;
        this.description = description;
        this.inventoryType = inventoryType;
        this.stock = stock;
        UnitPrice = unitPrice;
        this.status = status;
    }

    public Item() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @ManyToOne()
    @JoinColumn(name = "inventory_type_id")
    private InventoryType inventoryType;
    @NotNull
    private Long stock;
    @NotNull
    private Double UnitPrice;
    @NotNull
    @ColumnDefault(value = "0")
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
