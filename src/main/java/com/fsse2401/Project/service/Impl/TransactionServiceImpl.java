package com.fsse2401.Project.service.Impl;

import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.TransactionStatus;
import com.fsse2401.Project.data.transaction.domain.TransactionResponseData;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import com.fsse2401.Project.exception.CartEmptyException;
import com.fsse2401.Project.exception.PayTransactionException;
import com.fsse2401.Project.exception.TransactionNotFoundException;
import com.fsse2401.Project.repository.TransactionRepository;
import com.fsse2401.Project.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final UserService userService;
    private final CartItemService cartItemService;
    private final TransactionRepository transactionRepository;
    private final TransactionProductService transactionProductService;

    private final ProductService productService;

    @Autowired
    public TransactionServiceImpl(UserService userService, CartItemService cartItemService, TransactionRepository transactionRepository, TransactionProductService transactionProductService, ProductService productService) {
        this.userService = userService;
        this.cartItemService = cartItemService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
        this.productService = productService;
    }



    @Override
    public TransactionResponseData createtransaction(FirebaseUserData firebaseUserData){
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            List<CartItemEntity> userCartItem = cartItemService.getByUser(userEntity);
            if (userCartItem.isEmpty()) {
                throw new CartEmptyException();
            }
            TransactionEntity transactionEntity = new TransactionEntity(userEntity);
            transactionEntity = transactionRepository.save(transactionEntity);

            List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO;
            for (CartItemEntity cartItem : userCartItem) {
                TransactionProductEntity transactionProductEntity = transactionProductService.createTransactionProduct(transactionEntity, cartItem);
                transactionProductEntityList.add(transactionProductEntity);
                total = total.add(
                        transactionProductEntity.getPrice().multiply(
                                new BigDecimal(transactionProductEntity.getQuantity()))
                );

            }
            transactionEntity.setTotal(total);
            transactionEntity = transactionRepository.save(transactionEntity);
            TransactionResponseData transactionResponseData = new TransactionResponseData(transactionEntity, transactionProductEntityList);
            return transactionResponseData;

        } catch (CartEmptyException ex) {
            logger.warn(ex.getMessage());
            throw ex;

        }
    }

    @Override
    public TransactionResponseData getByTid(int tid, FirebaseUserData firebaseUserData) {
        try {
            TransactionEntity transactionEntity = getEntityByTidandFirebaseUid(tid, firebaseUserData.getFirebasedUid());
            List<TransactionProductEntity> transactionProductEntityList = transactionProductService.getEntityListByTransaction(transactionEntity);
            return new TransactionResponseData(transactionEntity, transactionProductEntityList);
        } catch (TransactionNotFoundException ex) {
            logger.warn("Get transaction failed" + ex.getMessage());
            throw ex;
        }

    }

    @Override
    public boolean payTransaction(FirebaseUserData firebaseUserData, int tid) {
        try {
            TransactionEntity transactionEntity = getEntityByTidandFirebaseUid(tid, firebaseUserData.getFirebasedUid());
            if (transactionEntity.getStatus() != TransactionStatus.PERPARE) {
                throw new PayTransactionException("Status Error");
            }
            List<TransactionProductEntity> transactionProductEntityList = transactionProductService.getEntityListByTransaction(transactionEntity);
            for (TransactionProductEntity transactionProductEntity : transactionProductEntityList) {
                if (!productService.isValidQuantity(transactionProductEntity.getPid(), transactionProductEntity.getQuantity())) {
                    throw new PayTransactionException("Not enough stock:" + transactionProductEntity.getPid());
                }
            }
            for (TransactionProductEntity transactionProductEntity : transactionProductEntityList) {
                productService.deductProduct(transactionProductEntity.getPid(), transactionProductEntity.getQuantity());
            }
            transactionEntity.setStatus(TransactionStatus.PROCESSING);
            transactionRepository.save(transactionEntity);
            return true;
        } catch (Exception ex) {
            logger.warn("Pay transaction failed" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, int tid){
        try {
            TransactionEntity transactionEntity = getEntityByTidandFirebaseUid(tid, firebaseUserData.getFirebasedUid());
            if (transactionEntity.getStatus() != TransactionStatus.PROCESSING) {
                throw new PayTransactionException("Status Error");
            }
            cartItemService.emptyUserCart(firebaseUserData.getFirebasedUid());

            transactionEntity.setStatus(TransactionStatus.SUCCESS);
            return new TransactionResponseData(transactionEntity, transactionProductService.getEntityListByTransaction(transactionEntity)
            );
        }catch (Exception ex){
            logger.warn("Finish transaction failed"+ex.getMessage());
            throw ex;
        }
    }

    @Override
    public TransactionEntity getEntityByTidandFirebaseUid(int tid, String firebaseUid) {
        // or elsa throw lamda method
        return transactionRepository.findByTidAndUser_FirebaseUid(tid, firebaseUid).orElseThrow(
                () -> new TransactionNotFoundException(tid, firebaseUid)
        );
    }
}
