package com.fsse2401.Project.repository;

import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends CrudRepository<CartItemEntity,Integer> {
    Optional<CartItemEntity> findByProductAndUser(ProductEntity product, UserEntity user);
    boolean existsByProductAndUser (ProductEntity product,UserEntity user);
    List<CartItemEntity> findAllByUser(UserEntity user) ;
//    Integer deleteByProduct_PidAndUser_FireBaseUid(int pid,String firebaseuid);
    void deleteAllByUser_FirebaseUid(String firebaseUid);
}
