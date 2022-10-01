package com.cejgroup.inventorysystem.services.Transaction;

import com.cejgroup.inventorysystem.domain.entities.*;
import com.cejgroup.inventorysystem.domain.enums.TransactionType;
import com.cejgroup.inventorysystem.domain.interfaces.ItemStore.IItemStoreRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionRepository;
import com.cejgroup.inventorysystem.domain.interfaces.Transaction.ITransactionService;
import com.cejgroup.inventorysystem.dto.CreateTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;
    @Autowired
    private IItemStoreRepository itemStoreRepository;
    @Override
    public Collection<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Collection<TransactionType> getTransactionTypes() {
        return Arrays.asList(TransactionType.class.getEnumConstants());
    }

    @Override
    public void save(CreateTransactionDto dto) throws Exception{
        ItemStore itemStore = null;
        // verificar el tipo de transaccion
        switch (dto.getTransactionType()){
            case IN:
                // si es in, verificar si ya existe el item en ese store: sumar cantidad, sino agregarlo
                if(!dto.getStore().isPresent())
                    throw new Exception("El almacen no puede ser nulo.");

                itemStore = GetItemStoreByKey(dto.getItem(), dto.getStore().get());

                if(itemStore == null){
                    itemStore = new ItemStore(dto.getItem(),
                            dto.getStore().get(),
                            dto.getQuantity());
                } else {
                    int newQuantity = itemStore.getQuantity() + dto.getQuantity();
                    itemStore.setQuantity(newQuantity);
                }
                itemStoreRepository.save(itemStore);
                break;
            case OUT:
                // si es out, verificar si ya existe el item en ese store: restar cantidad: que no reste mas de lo que hay
                itemStore = GetItemStoreByKey(dto.getItem(), dto.getStore().get());

                int newQty = itemStore.getQuantity() - dto.getQuantity();
                if((itemStore.getQuantity() - dto.getQuantity()) < 0)
                    throw  new Exception("Cantidad ingresada es invalida");

                itemStore.setQuantity(newQty);

                itemStoreRepository.save(itemStore);
                break;
            case ADJUSTMENT:
                // si es adjustment, reemplazar cantidad especificada
                itemStore = GetItemStoreByKey(dto.getItem(), dto.getStore().get());
                itemStore.setQuantity(dto.getQuantity());

                itemStoreRepository.save(itemStore);
                break;
            case TRANSFER:
                // si es TRANSFER, verificar que no se lleve mas de lo que tiene de stock
                if(!dto.getStore().isPresent() || !dto.getDestinationStore().isPresent())
                    throw new Exception("Ninguno de los alamcenes pueden ser nulo.");

                ItemStore source = GetItemStoreByKey(dto.getItem(), dto.getStore().get());
                ItemStore destination = GetItemStoreByKey(dto.getItem(), dto.getDestinationStore().get());

                if((source.getQuantity() - dto.getQuantity()) < 0)
                    throw  new Exception("Cantidad ingresada es invalida");

                int destionationQty = 0;
                if(destination.getQuantity() == 0){
                    destionationQty = dto.getQuantity();
                } else {
                    destionationQty = dto.getQuantity() + destination.getQuantity();
                }
                destination.setQuantity(destionationQty);

                int newSourceQty = source.getQuantity() - dto.getQuantity();
                source.setQuantity(newSourceQty);
                itemStoreRepository.save(source);
                itemStoreRepository.save(destination);
                break;
        }
        // crear siempre un objeto transaccion con los datos requeridos
        Transaction transaction = new Transaction(
                new Date(),
                new Item(dto.getItem()),
                dto.getQuantity(),
                dto.getCost(),
                dto.getTransactionType()
        );
        transactionRepository.save(transaction);

    }


    private ItemStore GetItemStoreByKey(Long itemId, Long storeId) {
        var itemStoreId = new ItemStoreId(itemId, storeId);
        return itemStoreRepository.getById(itemStoreId);
    }
}
