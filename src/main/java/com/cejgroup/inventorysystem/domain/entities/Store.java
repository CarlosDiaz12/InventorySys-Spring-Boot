package com.cejgroup.inventorysystem.domain.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Table(name = "Stores")
@Entity
public class Store {
    public Store() {
    }

    public Store(Long id, String description, boolean status) {
        this.id = id;
        this.description = description;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @NotNull
    @ColumnDefault(value = "0")
    private boolean status;
}
