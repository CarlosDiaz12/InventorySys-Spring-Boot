package com.cejgroup.inventorysystem.domain.entities;

import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Transactions")
@Entity
public class Transaction {

    public Transaction() {
    }

    public Transaction(Date date, Item item, int quantity, double cost, TransactionType transactionType) {
        this.date = date;
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Date date;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @NotNull
    private Item item;
    @NotNull
    private int quantity;
    @NotNull
    private double cost;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
