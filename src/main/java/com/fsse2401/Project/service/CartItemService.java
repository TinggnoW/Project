package com.fsse2401.Project.service;

import com.fsse2401.Project.data.cart.domain.CartItemResponseData;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    boolean putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    List<CartItemResponseData> getCartItem(FirebaseUserData firebaseUserData);


    CartItemResponseData updateproduct(FirebaseUserData firebaseUserData, int pid, int quantity);

    boolean deleteproduct(FirebaseUserData firebaseUserData, int pid);

    Optional<CartItemEntity> getByProductAndUser(ProductEntity product, UserEntity user);

    List<CartItemEntity>getByUser(UserEntity user);

    @Transactional
    void emptyUserCart(String firebaseUid);

//    void emptyUserCart(String firebaseUid);

}
