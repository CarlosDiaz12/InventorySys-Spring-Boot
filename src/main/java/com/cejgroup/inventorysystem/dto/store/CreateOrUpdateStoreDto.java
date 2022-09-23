package com.cejgroup.inventorysystem.dto.store;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

public class CreateOrUpdateStoreDto {

    public CreateOrUpdateStoreDto() {
        this.status = true;
    }

    public CreateOrUpdateStoreDto(Long id, String description, Boolean status) {
        this.id = id;
        this.description = description;
        this.status = status;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    private Long id;
    @NotNull
    private String description;
    @NotNull
    private boolean status;

    private boolean isEditing;
}
