package com.fsse2401.Project.data.transaction.entity;

import com.fsse2401.Project.data.transaction.TransactionStatus;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.Project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    @ManyToOne
    @JoinColumn(name="uid",nullable=false)
    private UserEntity user;

    @Column(nullable=false)
    private LocalDateTime datetime;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    @Column(nullable=false)
    private BigDecimal total;

    public TransactionEntity( UserEntity user) {
        this.user = user;
        this.datetime = LocalDateTime.now();
        this.status = TransactionStatus.PERPARE ;
        this.total = BigDecimal.ZERO;
    }

    public TransactionEntity() {

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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

}
