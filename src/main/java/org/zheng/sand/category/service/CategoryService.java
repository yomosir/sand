package org.zheng.sand.category.service;

import org.zheng.sand.category.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有的类别数据
     * @return 返回类别实体对象的list
     */
    public List<Category> getCategoryListName();
}
