package com.cejgroup.inventorysystem.controllers;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeRepository;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeService;
import com.cejgroup.inventorysystem.domain.interfaces.Store.IStoreService;
import com.cejgroup.inventorysystem.dto.CreateEditInventoryTypeDto;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;
import com.cejgroup.inventorysystem.dto.store.CreateOrUpdateStoreDto;
import com.cejgroup.inventorysystem.services.InventoryType.InventoryTypeService;
import javassist.NotFoundException;
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
public class InventoryTypeController {
    @Autowired
    private IInventoryTypeService inventoryTypeService;
    @Autowired
    public InventoryTypeController(IInventoryTypeService inventoryTypeService) {
        this.inventoryTypeService = inventoryTypeService;
    }

    @GetMapping("/inventoryType/create")
    public ModelAndView createView(Model model) {
        CreateEditInventoryTypeDto inventoryType = new CreateEditInventoryTypeDto();
        var returnModel = new ModelAndView("/inventoryType/create");
        returnModel.addObject("inventoryType", inventoryType);
        return returnModel;
    }

    @PostMapping("/inventoryType/create")
    public String create(@Valid @ModelAttribute("inventoryType") CreateEditInventoryTypeDto inventoryType) throws Exception {
       // model.addAttribute("inventoryType", new CreateEditInventoryTypeDto());
        inventoryTypeService.add(inventoryType);
        return "redirect:/inventoryType/index";
    }

    @GetMapping("/inventoryType/edit/{id}")
    public ModelAndView editView(@PathVariable("id") Long id) throws NotFoundException {
        var returnModel = new ModelAndView("/inventoryType/edit");

        var inventoryType = inventoryTypeService.getById(id);
        CreateEditInventoryTypeDto inventoryTypeToEdit = inventoryTypeService.mapEntityToDto(inventoryType);
        Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();

        returnModel.addObject("inventoryTypes", inventoryTypeCollection);
        returnModel.addObject("inventoryType", inventoryTypeToEdit);

        return returnModel;
    }

    @PostMapping("/inventoryType/edit")
    public ModelAndView editMethod(@Valid @ModelAttribute("inventoryType") CreateEditInventoryTypeDto inventoryType, BindingResult bindingResult) throws Exception {
        var returnModel = new ModelAndView("/inventoryType/edit");
        if(bindingResult.hasErrors()){
            Collection<InventoryType> inventoryTypeCollection = inventoryTypeService.getAll();
            returnModel.addObject("inventoryTypes", inventoryTypeCollection);
            returnModel.addObject("inventoryType", inventoryType);
            return returnModel;
        }
        inventoryTypeService.edit(inventoryType);
        returnModel.setViewName("redirect:/inventoryType/index");
        return returnModel;
    }

    @GetMapping("/inventoryType/index")
    public ModelAndView index(Model model){
        var returnModel = new ModelAndView("/inventoryType/index");
        returnModel.addObject("inventoryTypes", inventoryTypeService.getAll());
        return returnModel;
    }
    @GetMapping("/inventoryType/delete/{id}")
    public ModelAndView deleteItem(@PathVariable("id") Long id) throws NotFoundException{
        var returnModel = new ModelAndView("redirect:/inventoryType/index");
        inventoryTypeService.deleteById(id);
        return returnModel;
    }
}
