package com.cejgroup.inventorysystem.services.Transaction;

import com.cejgroup.inventorysystem.domain.entities.Transaction;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionService;
import com.cejgroup.inventorysystem.dto.CreateTransactionDto;
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

    @Override
    public void save(CreateTransactionDto dto) {
        // verificar el tipo de transaccion
        // si es in, verificar si ya existe el item en ese store: sumar cantidad, sino agregarlo
        // si es out, verificar si ya existe el item en ese store: restar cantidad: que no reste mas de lo que hay
        // si es TRANSFER, verificar que no se lleve mas de lo que tiene de stock
        // si es adjustment, reemplazar cantidad especificada

        // crear siempre un objeto transaccion con los datos requeridos
    }
}
