package com.cejgroup.inventorysystem.domain.interfaces.Transaction;

import com.cejgroup.inventorysystem.domain.entities.Transaction;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;

import java.util.Collection;

public interface ITransactionService {
    Collection<Transaction> getAll();
    Collection<TransactionType> getTransactionTypes();
}
