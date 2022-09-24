package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.entities.Store;
import com.cejgroup.inventorysystem.domain.interfaces.Item.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ItemRestController {
    @Autowired
    private IItemService itemService;

    @GetMapping("/api/item/{id}/stores")
    public Collection<Store> getItemStores(@PathVariable Long id){
        return itemService.getItemStores(id);
    }
    @GetMapping("/api/item/{id}/not-in-stores")
    public Collection<Store> getNotInItemStores(@PathVariable Long id){
        return itemService.getNotInItemStores(id);
    }
}
