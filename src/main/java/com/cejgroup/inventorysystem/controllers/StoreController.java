package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreService;
import com.cejgroup.inventorysystem.domain.interfaces.User.IUserService;
import com.cejgroup.inventorysystem.dto.RegisterUserDto;
import com.cejgroup.inventorysystem.dto.store.CreateOrUpdateStoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoreController {

    private IStoreService storeService;

    @Autowired
    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/store")
    public String index(Model model){
        model.addAttribute("stores", storeService.getAll());
        return "/store/index";
    }

    @GetMapping("/store/create")
    public String create(Model model){
        model.addAttribute("store", new CreateOrUpdateStoreDto());
        return "/store/create";
    }

    @GetMapping("/store/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        var store = storeService.getById(id);
        if (store == null) {
            return "redirect:/store";
        }
        store.setEditing(true);
        model.addAttribute("store", store);
        return "/store/create";
    }

    @PostMapping("/store/create")
    public String create(@ModelAttribute("store")CreateOrUpdateStoreDto createOrUpdateStoreDto){
        storeService.create(createOrUpdateStoreDto);
        return "/store/index";
    }

    @PostMapping("/store/edit")
    public String edit(@ModelAttribute("store")CreateOrUpdateStoreDto createOrUpdateStoreDto){
        storeService.edit(createOrUpdateStoreDto);
        return "redirect:/store";
    }
}
