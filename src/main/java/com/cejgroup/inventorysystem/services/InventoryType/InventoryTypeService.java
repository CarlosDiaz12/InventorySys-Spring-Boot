package com.cejgroup.inventorysystem.services.InventoryType;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import com.cejgroup.inventorysystem.domain.entities.Item;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeRepository;
import com.cejgroup.inventorysystem.domain.interfaces.InventoryType.IInventoryTypeService;
import com.cejgroup.inventorysystem.dto.CreateEditInventoryTypeDto;
import com.cejgroup.inventorysystem.dto.CreateEditItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javassist.NotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryTypeService implements IInventoryTypeService {
    @Autowired
    private IInventoryTypeRepository inventoryTypeRepository;
    @Override
    public List<InventoryType> getAll() {
        return inventoryTypeRepository.findAll();
    }

    @Override
    public void add(CreateEditInventoryTypeDto dto) throws Exception{
        InventoryType newInventoryType = new InventoryType(
                dto.getDescription(),
                dto.getaccountantAccount(),
                dto.isStatus()
        );
        inventoryTypeRepository.save(newInventoryType);
    }

    @Override
    public void edit(CreateEditInventoryTypeDto dto) throws Exception {

        Optional<InventoryType> inventoryType = inventoryTypeRepository.findById(dto.getId());
        if(!inventoryType.isPresent())
            throw new Exception("La Cuenta contable no se encuentra");

        InventoryType editInventoryType = inventoryType.get();
        editInventoryType.setDescription(dto.getDescription());
        editInventoryType.setAccountantAccount(dto.getaccountantAccount());
        editInventoryType.setStatus(dto.isStatus());
        inventoryTypeRepository.save(editInventoryType);
    }

    @Override
    public InventoryType getById(Long id) throws NotFoundException {
        var inventoryType = inventoryTypeRepository.findById(id);
        if(!inventoryType.isPresent())
            throw new NotFoundException("No se encuentra la Cuenta contable");

        return inventoryType.get();
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        var inventoryType = inventoryTypeRepository.findById(id);
        if(!inventoryType.isPresent())
            throw new NotFoundException("No se encuentra la Cuenta contable");

        inventoryTypeRepository.deleteById(id);

    }

    @Override
    public CreateEditInventoryTypeDto mapEntityToDto(InventoryType inventoryType) {
        return new CreateEditInventoryTypeDto(
                inventoryType.getId(),
                inventoryType.getDescription(),
                inventoryType.getAccountantAccount(),
                inventoryType.isStatus()
        );
    }
}
