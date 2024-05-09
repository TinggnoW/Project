package com.fsse2401.Project.api;

import com.fsse2401.Project.config.EnvConfig;
import com.fsse2401.Project.data.cart.domain.CartItemResponseData;
import com.fsse2401.Project.data.cart.dto.CartItemSuccessDto;
import com.fsse2401.Project.data.cart.dto.GetCartItemDto;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.domain.UpdateProductData;
import com.fsse2401.Project.data.product.dto.UpdateProductDto;
import com.fsse2401.Project.repository.CartItemRepository;
import com.fsse2401.Project.service.CartItemService;
import com.fsse2401.Project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL, EnvConfig.PROD_S3_BASE_URL})
@RequestMapping("/cart")
public class CarItemApi {

    private final CartItemService cartItemService;

    @Autowired
    public CarItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }



    @PutMapping("/{pid}/{quantity}")
    public CartItemSuccessDto putCartItem (JwtAuthenticationToken jwtToken, @PathVariable Integer pid, @PathVariable Integer quantity){
    cartItemService.putCartItem(JwtUtil.getFirebaseUserData(jwtToken),pid,quantity);
    return new CartItemSuccessDto();
    }

    @GetMapping
    public List<GetCartItemDto> getCartItemDtoList(JwtAuthenticationToken jwtToken){
        List<GetCartItemDto> resultlist = new ArrayList<>();
        List<CartItemResponseData> datalist = cartItemService.getCartItem(JwtUtil.getFirebaseUserData(jwtToken));
        for (CartItemResponseData data: datalist){
            GetCartItemDto dto = new GetCartItemDto(data);
            resultlist.add(dto);
        }
        return resultlist;
    }

    @PatchMapping("/{pid}/{quantity}")
    public GetCartItemDto updateProductDto (JwtAuthenticationToken jwtToken,@PathVariable int pid, @PathVariable int quantity){
        return new GetCartItemDto(cartItemService.updateproduct(JwtUtil.getFirebaseUserData(jwtToken),pid,quantity));
    }

    @DeleteMapping("/{pid}")
    public CartItemSuccessDto deleteProductDto (JwtAuthenticationToken jwtToken,@PathVariable int pid){
        cartItemService.deleteproduct(JwtUtil.getFirebaseUserData(jwtToken),pid);
        return new CartItemSuccessDto();
    }


}
