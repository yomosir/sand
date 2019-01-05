package org.zheng.sand.category.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zheng.sand.category.dao.CategoryMapper;
import org.zheng.sand.category.entity.Category;
import org.zheng.sand.category.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryListName() {
        return categoryMapper.getCategoryList();
    }
}
