package com.cejgroup.inventorysystem.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateEditInventoryTypeDto {

    public CreateEditInventoryTypeDto(){
        this.status = true;
    }

    public CreateEditInventoryTypeDto (Long id, String description, int accountantAccount, boolean status){
        this.id = id;
        this.description = description;
        this.accountantAccount = accountantAccount;
        this.status = status;
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
    @Min(0)
    private int accountantAccount;

    private boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getaccountantAccount() {
        return accountantAccount;
    }

    public void setaccountantAccount(int accountantAccount) {
        this.accountantAccount = accountantAccount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
