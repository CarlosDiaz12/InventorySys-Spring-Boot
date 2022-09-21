package com.cejgroup.inventorysystem.domain.interfaces.InventoryType;

import com.cejgroup.inventorysystem.domain.entities.InventoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryTypeRepository extends JpaRepository<InventoryType, Long> {
}
