package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeService;
import com.cejgroup.inventorysystem.domain.interfaces.Item.IItemService;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;
import com.cejgroup.inventorysystem.dto.CreateItemDto;
import com.cejgroup.inventorysystem.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class ItemController {
    @Autowired
    private IItemService itemService;
    @Autowired
    private IInventoryTypeService inventoryTypeService;

    @GetMapping("/item/create")
    public ModelAndView createView(Model model) {
        CreateEditItemDto item = new CreateEditItemDto();
        Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();
        var returnModel = new ModelAndView("/item/create");
        returnModel.addObject("inventoryTypes", inventoryTypeCollection);
        returnModel.addObject("item", item);
        return returnModel;
    }

    @PostMapping("/item/create")
    public ModelAndView createMethod(@Valid @ModelAttribute("item") CreateEditItemDto item, BindingResult bindingResult) throws Exception {
        var returnModel = new ModelAndView("/item/create");
        if(bindingResult.hasErrors()){
            Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();
            returnModel.addObject("inventoryTypes", inventoryTypeCollection);
            returnModel.addObject("item", item);
            return returnModel;
        }
        itemService.add(item);
        returnModel.setViewName("redirect:/item/index");
        return returnModel;
    }

    @GetMapping("/item/edit/{id}")
    public ModelAndView editView(@PathVariable("id") Long id, odel model) {
        var returnModel = new ModelAndView("/item/create");
        // recibir parametro y obtener el item desde la db;
        CreateEditItemDto item = new CreateEditItemDto();

        Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();

        returnModel.addObject("inventoryTypes", inventoryTypeCollection);
        returnModel.addObject("item", item);

        return returnModel;
    }

    @PostMapping("/item/edit")
    public ModelAndView editMethod(@Valid @ModelAttribute("item") CreateEditItemDto item, BindingResult bindingResult) throws Exception {
        var returnModel = new ModelAndView("/item/edit");
        if(bindingResult.hasErrors()){
            Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();
            returnModel.addObject("inventoryTypes", inventoryTypeCollection);
            returnModel.addObject("item", item);
            return returnModel;
        }
        itemService.edit(item);
        returnModel.setViewName("redirect:/item/index");
        return returnModel;
    }

    @GetMapping("/item/index")
    public ModelAndView index(Model model){
        var returnModel = new ModelAndView("/item/index");
        returnModel.addObject("items", itemService.getAll());
        return returnModel;
    }
}
