package com.rent.rentApp.mapper;
import com.rent.rentApp.model.Cart;
import com.rent.rentApp.model.Category;
import com.rent.rentApp.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
   List<Category> findCategory();
   List<Type> findTypeByName(String categoryName);


}
