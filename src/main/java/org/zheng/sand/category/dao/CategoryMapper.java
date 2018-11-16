package org.zheng.sand.category.dao;

import org.zheng.sand.category.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(String caid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String caid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}