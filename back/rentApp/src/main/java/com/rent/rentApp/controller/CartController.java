package com.rent.rentApp.controller;

import com.rent.rentApp.model.Cart;
import com.rent.rentApp.service.CartService;
import com.rent.rentApp.service.impl.CartServiceImpl;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    Cart cart = new Cart();
    //添加购物车模块
    @RequestMapping(value = "/cart/addCart", method = RequestMethod.POST)
    public MsgResponse addCart(@RequestParam Integer productId, @RequestParam Integer stuNumber){
        cart.setProductId(productId);
        cart.setStuNumber(stuNumber);
        MsgResponse resurt = cartService.addCart(cart);
        return resurt;
    }
    //查询购物车模块
    @RequestMapping(value = "/cart/getCart", method = RequestMethod.GET)
    public MsgResponse getCart (Integer stuNumber){
        System.out.println(stuNumber);
        MsgResponse cart = cartService.getCart(stuNumber);
        return cart;
    }
}
