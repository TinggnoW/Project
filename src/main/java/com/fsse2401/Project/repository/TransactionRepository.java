package com.fsse2401.Project.repository;

import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
     // underscore mean atrributes of the entity
     Optional<TransactionEntity> findByTidAndUser_FirebaseUid(int tid,String firebaseUid);

}
