package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import java.util.Collection;

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

    public InventoryType(String description) {
        this.description = description;
    }
}
