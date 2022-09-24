package com.cejgroup.inventorysystem.services.Transaction;

import com.cejgroup.inventorysystem.domain.entities.Transaction;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;
    @Override
    public Collection<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Collection<TransactionType> getTransactionTypes() {
        return Arrays.asList(TransactionType.class.getEnumConstants());
    }
}
