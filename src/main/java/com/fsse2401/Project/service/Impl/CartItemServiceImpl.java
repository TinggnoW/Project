package com.fsse2401.Project.service.Impl;

import com.fsse2401.Project.data.cart.domain.CartItemResponseData;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import com.fsse2401.Project.exception.ProductNotFoundException;
import com.fsse2401.Project.exception.PutCartItemException;
import com.fsse2401.Project.repository.CartItemRepository;
import com.fsse2401.Project.service.CartItemService;
import com.fsse2401.Project.service.ProductService;
import com.fsse2401.Project.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public boolean putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {

        try {

            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getEntityByPid(pid);
            Optional<CartItemEntity> cartItemEntityOptional = getByProductAndUser(productEntity, userEntity);
            if (cartItemEntityOptional.isEmpty()) {
                if (!productService.isValidQuantity(productEntity, quantity)) {
                    throw new PutCartItemException();
                }
                CartItemEntity cartItemEntity = new CartItemEntity(productEntity, userEntity, quantity);
                cartItemRepository.save(cartItemEntity);
            } else {
                if (!productService.isValidQuantity(productEntity, quantity)) {
                    throw new PutCartItemException();
                }
                cartItemEntityOptional.get().setQuantity(cartItemEntityOptional.get().getQuantity() + quantity);
                cartItemRepository.save(cartItemEntityOptional.get());
            }
            return true;

        } catch (ProductNotFoundException | PutCartItemException ex) {
            logger.warn("Put CartItem Failed" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<CartItemResponseData> getCartItem(FirebaseUserData firebaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemResponseData> result = new ArrayList<>();
        for (CartItemEntity entity : cartItemRepository.findAllByUser(userEntity)) {
            CartItemResponseData data = new CartItemResponseData(entity);
            result.add(data);
        }
        return result;
    }

    @Override
    public CartItemResponseData updateproduct(FirebaseUserData firebaseUserData, int pid, int quantity) {
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getEntityByPid(pid);
            Optional<CartItemEntity> cartItemEntityOptional = getByProductAndUser(productEntity, userEntity);
            if (cartItemEntityOptional.isEmpty()) {
                throw new ProductNotFoundException();
            }
            if (!productService.isValidQuantity(productEntity, quantity)) {
                throw new PutCartItemException();
            }
            cartItemEntityOptional.get().setQuantity(quantity);

            cartItemRepository.save(cartItemEntityOptional.get());

            return new CartItemResponseData(cartItemEntityOptional.get());

        } catch (ProductNotFoundException | PutCartItemException ex) {
            logger.warn("Put CartItem Failed" + ex.getMessage());
            throw ex;

        }

    }

    @Override
    public boolean deleteproduct(FirebaseUserData firebaseUserData, int pid) {
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getEntityByPid(pid);
            Optional<CartItemEntity> cartItemEntityOptional = getByProductAndUser(productEntity, userEntity);
            if (cartItemEntityOptional.isEmpty()) {
                throw new ProductNotFoundException();
            }
            cartItemRepository.delete(cartItemEntityOptional.get());
            ;
            return true;

        } catch (ProductNotFoundException ex) {
            logger.warn("Remove CartItem Failed" + ex.getMessage());
            throw ex;

        }
    }

    @Override
    public Optional<CartItemEntity> getByProductAndUser(ProductEntity product, UserEntity user) {
        return cartItemRepository.findByProductAndUser(product, user);
    }

    @Override
    public List<CartItemEntity> getByUser(UserEntity user) {
        return cartItemRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public void emptyUserCart(String firebaseUid){
        cartItemRepository.deleteAllByUser_FirebaseUid(firebaseUid);
    }


}



