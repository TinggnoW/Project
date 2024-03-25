package com.fsse2401.Project.service.Impl;

import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.Project.repository.TransactionProductRepository;
import com.fsse2401.Project.service.TransactionProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionProductServiceImpl implements TransactionProductService {
    Logger logger = LoggerFactory.getLogger(TransactionProductServiceImpl.class);


    private final TransactionProductRepository transactionProductRepository;

    @Autowired
    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public TransactionProductEntity createTransactionProduct(TransactionEntity transactionEntity, CartItemEntity cartItem){

        return transactionProductRepository.save(new TransactionProductEntity(transactionEntity,cartItem));

    }


    @Override
    public List<TransactionProductEntity> getEntityListByTransaction(TransactionEntity transactionEntity){
        return transactionProductRepository.findAllByTransaction(transactionEntity);

    }


}

