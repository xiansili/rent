package com.rent.rentApp.mapper;

import com.rent.rentApp.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductMapper {
    List<Product> getProductsByType(String productType);

    Product getDetailById(Integer productId);
}
