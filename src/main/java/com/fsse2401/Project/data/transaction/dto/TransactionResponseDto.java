package com.fsse2401.Project.data.transaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.TransactionStatus;
import com.fsse2401.Project.data.transaction.domain.TransactionResponseData;
import com.fsse2401.Project.data.transactionProduct.domain.TransactionProductResponseData;
import com.fsse2401.Project.data.transactionProduct.dto.TransactionProductResponseDto;
import com.fsse2401.Project.data.user.domain.UserResponseData;
import com.fsse2401.Project.data.user.dto.UserResponseDto;
import com.fsse2401.Project.data.user.entity.UserEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    private int tid;
    @JsonProperty("buyer_uid")
    private UserResponseDto user;

    @JsonFormat(pattern = "YYYY-MM-DD' T 'HH:MM:SS")
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    private List<TransactionProductResponseDto> items = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData data) {
        this.tid = data.getTid();
        this.user = new UserResponseDto(data.getUser());
        this.datetime = data.getDatetime();
        this.status = data.getStatus();
        this.total = data.getTotal();
        setItems(data);
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto user) {
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

    public List<TransactionProductResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductResponseDto> items) {
        this.items = items;
    }

    public void setItems (TransactionResponseData data){
        for (TransactionProductResponseData item : data.getTransactionProductList()){
            this.items.add(new TransactionProductResponseDto(item));
        }
    }
}
