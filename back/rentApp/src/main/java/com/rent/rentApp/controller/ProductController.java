package com.rent.rentApp.controller;

import com.rent.rentApp.model.Product;
import com.rent.rentApp.service.ProductService;
import com.rent.rentApp.service.impl.ProductServiceImpl;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @RequestMapping(value = "/product/getProductsByType", method = RequestMethod.GET)
    public MsgResponse getProductsByType(String productType){
        MsgResponse products = productService.getProductsByType(productType);
        return products;
    }

//获取商品详情
    @RequestMapping(value = "/product/getDetail", method = RequestMethod.GET)
    public MsgResponse getDetail(Integer productId){
        MsgResponse product = productService.getDetail(productId);
        return product;
    }
}
