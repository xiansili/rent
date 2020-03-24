package com.rent.rentApp.service.impl;

import com.rent.rentApp.mapper.CartMapper;
import com.rent.rentApp.model.Cart;
import com.rent.rentApp.service.CartService;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
     private CartMapper cartMapper;

    @Autowired
    private ProductServiceImpl  productService;

    @Override
    public MsgResponse addCart(Cart cart) {
        MsgResponse msgResponse = new MsgResponse();
        //        判断是否已经加入购物车，避免重新加入
        Cart cartByProductId = cartMapper.getCartByProductId(cart);
        if (cartByProductId == null){
            int resurt = cartMapper.addCart(cart);
            msgResponse.setStatus(200);
            msgResponse.setMessage("加入购物车成功");
            return msgResponse;
        }else {
            msgResponse.setStatus(500);
            msgResponse.setMessage("购物车已存在该商品，请勿重新添加");
            return msgResponse;
        }
    }


    @Override
    public MsgResponse getCart(Integer stuNumber) {
        List<Cart> cart = cartMapper.getCart(stuNumber);
        List<Object> allCart = new ArrayList<>();
        for (int i=0; i<cart.size(); i++ ){
            cart.get(i).getProductId();
            MsgResponse detail = productService.getDetail(cart.get(i).getProductId());
            allCart.add(detail.getData());
        }
        if (cart == null){
            MsgResponse err = MsgResponse.err("购物车为空，请先添加");
            return err;
        }else {
            MsgResponse success = MsgResponse.success("查询成功", allCart);
            return success;
        }
    }
}
