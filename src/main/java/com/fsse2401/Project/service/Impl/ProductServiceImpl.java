package com.fsse2401.Project.service.Impl;

import com.fsse2401.Project.data.product.domain.GetProductResponseData;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.exception.ProductNotFoundException;
import com.fsse2401.Project.repository.ProductRepository;
import com.fsse2401.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetProductResponseData> getProduct() {
        List<GetProductResponseData> result = new ArrayList<>();
        for (ProductEntity product : productRepository.findAll()) {
            GetProductResponseData data = new GetProductResponseData(product);
            result.add(data);
        }
        return result;
    }

    @Override
    public GetProductResponseData getProductbyid(int id) {
        return new GetProductResponseData(getEntityByPid(id));
    }

    @Override
    public ProductEntity getEntityByPid(int pid) {
        Optional<ProductEntity> productEntityOptional = productRepository.findByPid(pid);
        return productEntityOptional.orElseThrow(ProductNotFoundException::new);

    }

    @Override
    public boolean deductProduct(int pid, int amount) {
        ProductEntity entity = getEntityByPid(pid);
        if (!isValidQuantity(entity, amount)) {
            return false;
        }
        entity.setStock(entity.getStock() - amount);
        productRepository.save(entity);
        return true;
    }

    @Override
    public boolean isValidQuantity(Integer quantity) {
        return false;
    }

    @Override
    public boolean isValidQuantity(ProductEntity entity, Integer quantity) {
        if (quantity < 1) {
            return false;
        } else if (quantity > entity.getStock()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isValidQuantity(int pid, Integer quantity) {
        ProductEntity entity = getEntityByPid(pid);
        if (quantity < 1) {
            return false;
        } else if (quantity > entity.getStock()) {
            return false;
        } else {
            return true;
        }
    }
}
