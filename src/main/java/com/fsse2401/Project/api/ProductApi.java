package com.fsse2401.Project.api;

import com.fsse2401.Project.config.EnvConfig;
import com.fsse2401.Project.data.product.domain.GetProductResponseData;
import com.fsse2401.Project.data.product.dto.GetProductResponseDto;
import com.fsse2401.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
// more than one local use ({http://...},{http://})
@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL, EnvConfig.PROD_S3_BASE_URL})

public class ProductApi {
    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/public/product")
    public List<GetProductResponseDto> getProduct (){
        List<GetProductResponseDto> result = new ArrayList<>();
        List<GetProductResponseData> data = productService.getProduct();
        for(GetProductResponseData entity:data){
            result.add(new GetProductResponseDto(entity));
        }
        return result;
    }

    @GetMapping("/public/product/{id}")
    public GetProductResponseDto getProductbyid (@PathVariable int id){
        return new GetProductResponseDto(
                productService.getProductbyid(id)
        );
    }


}
