package com.cejgroup.inventorysystem.domain.interfaces.Store;

import com.cejgroup.inventorysystem.domain.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreRepository extends JpaRepository<Store, Long> {
}
