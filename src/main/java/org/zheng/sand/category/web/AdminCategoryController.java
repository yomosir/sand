package org.zheng.sand.category.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.category.entity.Category;
import org.zheng.sand.category.service.CategoryService;
import org.zheng.sand.common.Response;
import org.zheng.sand.common.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;
    /* 管理端对类别的操作 ： 1.类别列表 2.按照名称搜索类别 3.添加类别 4，修改类别 5.删除类别 6.类别详情  */
    public Response getCategoryList(){
        List<Category> categoryList = categoryService.getCategoryListName();
        return ResponseUtil.success(categoryList);
    }

    public Response searchCategories(String cateName){
        return null;
    }

    public Response addCategory(Category category){
        return null;
    }

    public Response updateCategory(Category category){
        return null;
    }

    public Response deleteCategory(String id){
        return null;
    }

    public Response categoryDetail(String id){
        return null;
    }
}
