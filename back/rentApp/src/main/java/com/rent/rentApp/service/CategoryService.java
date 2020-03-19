package com.rent.rentApp.service;

import com.rent.rentApp.util.MsgResponse;

public interface CategoryService {
    /**
     * @return 查找类型
     */
    MsgResponse findCategory();

    //根据分类名称查找类型信息
    MsgResponse findTypeByName(String categoryName);
}
