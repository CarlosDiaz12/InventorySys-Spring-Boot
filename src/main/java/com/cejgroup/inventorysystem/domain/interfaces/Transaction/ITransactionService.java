package com.cejgroup.inventorysystem.domain.interfaces.Transaction;

import com.cejgroup.inventorysystem.domain.entities.Transaction;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import com.cejgroup.inventorysystem.dto.CreateTransactionDto;

import java.util.Collection;

public interface ITransactionService {
    Collection<Transaction> getAll();
    Collection<TransactionType> getTransactionTypes();
    void save(CreateTransactionDto dto) throws Exception;
}
