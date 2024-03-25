package com.fsse2401.Project.service;

import com.fsse2401.Project.data.transaction.domain.TransactionResponseData;
import com.fsse2401.Project.data.transaction.dto.TransactionResponseDto;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.user.domain.FirebaseUserData;

public interface TransactionService {

    TransactionResponseData createtransaction(FirebaseUserData firebaseUserData);

    TransactionResponseData getByTid(int tid, FirebaseUserData firebaseUserData);

    boolean payTransaction(FirebaseUserData firebaseUserData, int tid);


    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, int tid);

    TransactionEntity getEntityByTidandFirebaseUid(int tid, String firebaseUid);
}
