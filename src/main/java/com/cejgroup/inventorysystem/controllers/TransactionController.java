package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.interfaces.Item.IItemService;
import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreService;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionService;
import com.cejgroup.inventorysystem.dto.CreateTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private IItemService itemService;

    @Autowired
    private IStoreService storeService;
    @GetMapping("/transaction/index")
    public String index(Model model){

        model.addAttribute("transactions", transactionService.getAll());
        return "/transaction/index";
    }

    @GetMapping("/item/test")
    public Collection<Item> test(){
        return itemService.getAll();
    }

    @GetMapping("/transaction/create")
    public String createTransaction(Model model){
        model.addAttribute("transaction", new CreateTransactionDto());
        model.addAttribute("items", itemService.getAll());
        model.addAttribute("stores", storeService.getAll());
        model.addAttribute("transactionTypes", transactionService.getTransactionTypes());
        return "/transaction/create";
    }

    @PostMapping("/transaction/create")
    public String postTransaction(@Valid CreateTransactionDto transactionDto, Model model) {
        try{


        }catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "/transaction/create";
    }
}
