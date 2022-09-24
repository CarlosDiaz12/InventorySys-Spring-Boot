package com.cejgroup.inventorysystem.dto;

import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.Optional;

public class CreateTransactionDto {
    public CreateTransactionDto() {
    }
    @NotNull
    private Long item;
    @Min(1)
    private int quantity;

    public CreateTransactionDto(Long item, int quantity, double cost, TransactionType transactionType, Optional<Long> store, Optional<Long> destinationStore) {
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
        this.transactionType = transactionType;
        this.store = store;
        this.destinationStore = destinationStore;
    }

    @NotNull
    @DecimalMin("1.0")
    private double cost;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Optional<Long> store;
    private Optional<Long> destinationStore;

    public Optional<Long> getDestinationStore() {
        return destinationStore;
    }

    public void setDestinationStore(Optional<Long> destinationStore) {
        this.destinationStore = destinationStore;
    }

    public Optional<Long> getStore() {
        return store;
    }

    public void setStore(Optional<Long> store) {
        this.store = store;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
