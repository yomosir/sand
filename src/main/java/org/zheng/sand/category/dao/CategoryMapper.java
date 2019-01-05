package org.zheng.sand.category.dao;

import org.springframework.stereotype.Repository;
import org.zheng.sand.category.entity.Category;

import java.util.List;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(String caid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String caid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getCategoryList();
}