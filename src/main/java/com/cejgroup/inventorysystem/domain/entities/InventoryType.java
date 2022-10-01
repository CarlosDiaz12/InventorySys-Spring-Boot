package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "InventoryTypes")
@Entity
public class InventoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;

    public InventoryType() {
    }

    public InventoryType(String description, int accountantAccount, boolean status) {
        this.id = id;
        this.description = description;
        this.accountantAccount = accountantAccount;
        this.status = status;
    }

    @javax.validation.constraints.NotNull(message = "Requerido")
    @Min(0)
    private int accountantAccount;

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

    public int getAccountantAccount() {
        return accountantAccount;
    }

    public void setAccountantAccount(int accountantAccount) {
        this.accountantAccount = accountantAccount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
