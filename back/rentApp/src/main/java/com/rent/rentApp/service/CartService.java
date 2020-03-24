package com.rent.rentApp.service;

import com.rent.rentApp.model.Cart;
import com.rent.rentApp.util.MsgResponse;

public interface CartService {
    public MsgResponse addCart(Cart cart);
    public MsgResponse getCart(Integer stuNumber);
}