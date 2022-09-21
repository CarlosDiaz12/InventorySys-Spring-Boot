package com.cejgroup.inventorysystem.domain.interfaces.Transaction;

import com.cejgroup.inventorysystem.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}
