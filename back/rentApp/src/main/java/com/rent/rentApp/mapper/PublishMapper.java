package com.rent.rentApp.mapper;

import com.rent.rentApp.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PublishMapper {
    int publish(Product product);
}
