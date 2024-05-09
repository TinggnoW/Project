package com.fsse2401.Project.api;

import com.fsse2401.Project.config.EnvConfig;
import com.fsse2401.Project.data.transaction.domain.TransactionResponseData;
import com.fsse2401.Project.data.transaction.dto.TransactionResponseDto;
import com.fsse2401.Project.data.transactionProduct.dto.TransactionSuccessDto;
import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.service.TransactionService;
import com.fsse2401.Project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL, EnvConfig.PROD_S3_BASE_URL})
@RequestMapping("/transaction")
public class TransactionApi {


    private final TransactionService transactionService;

    @Autowired
    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto prepareTransaction (JwtAuthenticationToken jwtToken) {
        TransactionResponseData responseData = transactionService.createtransaction(JwtUtil.getFirebaseUserData(jwtToken));
        return new TransactionResponseDto(responseData);

    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getAllTransaction (@PathVariable int tid, JwtAuthenticationToken jwtToken){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        return new TransactionResponseDto(
          transactionService.getByTid(tid,firebaseUserData)
        );
    }

    @PatchMapping("/{tid}/pay")
    public TransactionSuccessDto payTransaction(@PathVariable int tid, JwtAuthenticationToken jwtToken){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwtToken);
        transactionService.payTransaction(firebaseUserData,tid);
        return new TransactionSuccessDto();
    }

    @PatchMapping("/{tid}/finish")
    public TransactionResponseDto finishTransactionByTid (@PathVariable int tid, JwtAuthenticationToken jwtToken){
        return new TransactionResponseDto(transactionService.finishTransaction(JwtUtil.getFirebaseUserData(jwtToken),tid)
        );
    }
}
