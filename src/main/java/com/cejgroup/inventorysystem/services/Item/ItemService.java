package com.cejgroup.inventorysystem.services.Item;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Item.IItemRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Item.IItemService;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {
    @Autowired
    private IItemRepository itemRepository;
    @Autowired
    private IInventoryTypeRepository inventoryTypeRepository;
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public void add(CreateEditItemDto dto) throws Exception {
        Optional<InventoryType> inventoryType = inventoryTypeRepository.findById(dto.getInventoryType());
        if(!inventoryType.isPresent())
            throw new Exception("Tipo de inventario no se encuentra");

        Item newItem = new Item(
                dto.getDescription(),
                inventoryType.get(),
                dto.getStock(),
                dto.getUnitPrice(),
                dto.isStatus()
        );
        itemRepository.save(newItem);
    }

    @Override
    public void edit(CreateEditItemDto dto) throws Exception {
        Optional<InventoryType> inventoryType = inventoryTypeRepository.findById(dto.getInventoryType());
        if(!inventoryType.isPresent())
            throw new Exception("Tipo de inventario no se encuentra");

        Optional<Item> item = itemRepository.findById(dto.getId());
        if(!item.isPresent())
            throw new Exception("El articulo no se encuentra");

        Item editItem = item.get();
        editItem.setDescription(dto.getDescription());
        editItem.setStock(dto.getStock());
        editItem.setUnitPrice(dto.getUnitPrice());
        editItem.setInventoryType(inventoryType.get());
        editItem.setStatus(dto.isStatus());

        itemRepository.save(editItem);
    }

    @Override
    public Item getById(Long id) throws NotFoundException {
        var item = itemRepository.findById(id);
        if(!item.isPresent())
            throw new NotFoundException("No se encuentra el articulo");

        return item.get();
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        var item = itemRepository.findById(id);
        if(!item.isPresent())
            throw new NotFoundException("No se encuentra el articulo");

        itemRepository.deleteById(id);
    }

    @Override
    public CreateEditItemDto mapEntityToDto(Item item) {
        return new CreateEditItemDto(
          item.getId(),
          item.getDescription(),
          item.getInventoryType().getId(),
          item.getStock(),
          item.getUnitPrice(), item.isStatus()
        );
    }
}
