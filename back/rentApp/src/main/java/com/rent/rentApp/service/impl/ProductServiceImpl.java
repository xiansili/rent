package com.rent.rentApp.service.impl;

import com.rent.rentApp.mapper.ProductMapper;
import com.rent.rentApp.model.Product;
import com.rent.rentApp.service.ProductService;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
        private ProductMapper productMapper;

//    根据类型获取商品
    @Override
    public MsgResponse getProductsByType(String productType) {
        List<Product> goods = productMapper.getProductsByType(productType);
        if (goods!=null){
            MsgResponse goodsList = MsgResponse.success("获取商品成功", goods);
            return goodsList;
        }else {
            MsgResponse err = MsgResponse.err("获取商品成功,请重新尝试");
            return err;
        }
    }
    //    获取商品详情
    @Override
    public MsgResponse getDetail(Integer productId) {
        Product detailById = productMapper.getDetailById(productId);
        if (detailById!=null){
            MsgResponse success = MsgResponse.success("查询成功", detailById);
            return success;
        }else{
            MsgResponse err = MsgResponse.err("查询失败");
            return err;
        }
    }
}
