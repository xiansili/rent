package com.rent.rentApp.mapper;

import com.rent.rentApp.model.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CartMapper {
    int addCart(Cart cart);

    List<Cart> getCart(Integer stuNumber);

    Cart getCartByProductId(Cart cart);
}
