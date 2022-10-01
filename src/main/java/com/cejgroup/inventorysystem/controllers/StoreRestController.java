package com.cejgroup.inventorysystem.controllers;
import com.cejgroup.inventorysystem.domain.entities.Store;
import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StoreRestController {
    @Autowired
    private IStoreService storeService;

    @GetMapping("/api/store/all")
    public Collection<Store> getAll(){
        return storeService.getAll();
    }
}
