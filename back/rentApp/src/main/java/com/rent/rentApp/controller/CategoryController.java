package com.rent.rentApp.controller;

import com.rent.rentApp.service.impl.CategoryServiceImpl;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @RequestMapping(value = "/type/getTypes", method = RequestMethod.GET)
    public MsgResponse findCategory(){
        MsgResponse category = categoryService.findCategory();
        return category;
    }

//根据分类名称查找类型信息
    @RequestMapping(value = "/type/getAllTypes", method = RequestMethod.GET)
    public MsgResponse findTypeByName(String categoryName){
        System.out.println(categoryName);
        MsgResponse category = categoryService.findTypeByName(categoryName);
        return category;
    }

}
