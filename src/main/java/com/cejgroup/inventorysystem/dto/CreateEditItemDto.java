package com.cejgroup.inventorysystem.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateEditItemDto {
    public CreateEditItemDto(Long id, String description, Long inventoryType, Long stock, Double unitPrice, boolean status) {
        this.id = id;
        this.description = description;
        this.inventoryType = inventoryType;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.status = status;
    }

    public CreateEditItemDto() {
    }
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Requerido")
    private String description;
    @NotNull(message = "Requerido")
    @Min(value = 1, message = "Requerido")
    private Long inventoryType;
    @NotNull(message = "Requerido")
    @Min(0)
    private Long stock;
    @NotNull(message = "Requerido")
    @DecimalMin("0.0")
    private Double unitPrice;
    private boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Long inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
