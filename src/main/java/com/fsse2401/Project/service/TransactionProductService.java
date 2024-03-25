package com.fsse2401.Project.service;


import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {
    TransactionProductEntity createTransactionProduct(TransactionEntity transactionEntity, CartItemEntity cartItem);


    List<TransactionProductEntity> getEntityListByTransaction(TransactionEntity transactionEntity);
}
