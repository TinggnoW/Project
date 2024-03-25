package com.fsse2401.Project.data.transaction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.TransactionStatus;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.transactionProduct.domain.TransactionProductResponseData;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.Project.data.user.domain.UserResponseData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import com.fsse2401.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;

public class TransactionResponseData {

    private int tid;
    @JsonProperty("buyer_uid")
    private UserResponseData user;
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    List<TransactionProductResponseData> transactionProductList = new ArrayList<>() ;

    public TransactionResponseData(TransactionEntity entity,List<TransactionProductEntity> transactionProductEntityList ) {
        this.tid = entity.getTid();
        this.user = new UserResponseData(entity.getUser());
        this.datetime = entity.getDatetime();
        this.status = entity.getStatus();
        this.total = entity.getTotal();
        setTransactionProductList(transactionProductEntityList);
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public UserResponseData getUser() {
        return user;
    }

    public void setUser(UserResponseData user) {
        this.user = user;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductResponseData> getTransactionProductList() {
        return transactionProductList;
    }



    public void setTransactionProductList(List<TransactionProductEntity> entityList){
        for (TransactionProductEntity transactionProductEntity: entityList){
            this.transactionProductList.add(
                    new TransactionProductResponseData(transactionProductEntity)
            );
        }
    }
}

