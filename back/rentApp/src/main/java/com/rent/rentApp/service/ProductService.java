package com.rent.rentApp.service;

import com.rent.rentApp.model.Product;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.stereotype.Service;


public interface ProductService {
    MsgResponse getProductsByType(String productType);
    MsgResponse getDetail(Integer productId);
}
