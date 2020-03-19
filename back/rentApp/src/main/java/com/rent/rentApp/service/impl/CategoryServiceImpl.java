package com.rent.rentApp.service.impl;
import com.rent.rentApp.mapper.CategoryMapper;
import com.rent.rentApp.model.Category;
import com.rent.rentApp.model.Type;
import com.rent.rentApp.service.CategoryService;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

//    查询类型
    @Override
    public MsgResponse findCategory() {
        List<Category> category = categoryMapper.findCategory();
        if (category == null){
            MsgResponse err = MsgResponse.err("查询失败，分类表中能够没有数据");
            return err;
        } else {
            MsgResponse success = MsgResponse.success("查询成功", category);
            return success;
        }
    }

//       根据分类名称获取商品类型
    @Override
    public MsgResponse findTypeByName(String categoryName) {
        List<Type> typeByName = categoryMapper.findTypeByName(categoryName);
        if (typeByName==null){
            MsgResponse err = MsgResponse.err("获取不到");
            return err;
        }else {
            MsgResponse success = MsgResponse.success("123", typeByName);
            return success;
        }
    }

}
